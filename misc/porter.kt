import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import java.io.FileInputStream
import java.io.FileOutputStream

// A converter from HardCoded configs to DataDriven configs to save time

private const val CONFIG_REGISTRY_PATH = "C:/Projects/Utopia/src/main/kotlin/com/redgrapefruit/utopia/common/registry/ConfigRegistry.kt"
private const val CONFIG_DIR_PATH = "C:/Projects/Utopia/src/main/resources/data/utopia/config/"
private const val CLASS_BODY_START = 10
private const val CLASS_BODY_END = 1134
private val NUMBERS = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

private val names = mutableListOf<String>()
private val JSON = Json { prettyPrint = true }

fun main() {
    val raw = readConfigRegistry()
    val lines = splitLines(raw)
    val body = getClassBody(lines)
    val declarations = getDeclarations(body)
    val declarationsNoWhitespaces = removeWhitespacesFromDeclarations(declarations)
    val declarationsMapped = mapDeclarations(declarationsNoWhitespaces)
    val declarationsNormalized = normalizeCategories(declarationsMapped)

    write(declarationsNormalized)
}

private fun readConfigRegistry(): String {
    val raw: String
    FileInputStream(CONFIG_REGISTRY_PATH).use { stream ->
        raw = stream.readBytes().decodeToString()
    }
    return raw
}

private fun splitLines(raw: String): List<String> = raw.split("\n")

private fun getClassBody(lines: List<String>): List<String> = lines.subList(CLASS_BODY_START, CLASS_BODY_END + 1)

private fun getDeclarations(body: List<String>): List<List<String>> {
    val globalList = mutableListOf<List<String>>()

    val currentList = mutableListOf<String>()
    var begin = false
    for (line in body) {
        if (line.contains("val")) {
            begin = true
            extractName(line)
            continue
        }

        if (line.contains("}")) {
            begin = false
            globalList += mutableListOf<String>().apply { addAll(currentList) }
            currentList.clear()
            continue
        }

        if (begin && line != "\r") currentList += line
    }

    return globalList
}

private fun extractName(line: String) {
    var out = line

    out = out.replace(" ", "")
    out = out.replace("val", "")
    out = out.replace("=", "")
    out = out.replace("{", "")
    out = out.replace("config", "")
    out = out.lowercase()

    names += out
}

private fun removeWhitespacesFromDeclarations(declarations: List<List<String>>): List<List<String>> {
    val out = mutableListOf<List<String>>()

    declarations.forEach { declaration ->
        val subOut = mutableListOf<String>()

        declaration.forEach { line ->
            val builder = StringBuilder()

            line.forEach { character ->
                if (character != ' ') builder.append(character)
            }

            subOut += builder.toString()
        }

        out += subOut
    }

    return out
}

private fun mapDeclarations(declarations: List<List<String>>): List<Map<String, String>> {
    val out = mutableListOf<Map<String, String>>()

    declarations.forEach { declaration ->
        val map = mutableMapOf<String, String>()

        declaration.forEach { line ->
            val rawSplit = line.split("=")
            val key = rawSplit[0]
            val value = rawSplit[1].removeSuffix("\r")
            map[key] = value
        }

        out += map
    }

    return out
}

private fun normalizeCategories(mapped: List<Map<String, String>>): List<Map<String, String>> {
    val out = mutableListOf<Map<String, String>>()

    mapped.forEach { map ->
        val resultMap = mutableMapOf<String, String>()

        map.forEach { (key, value) ->
            if (key == "category") {
                resultMap[key] = value.split(".")[1].lowercase()
            } else {
                resultMap[key] = value
            }
        }

        out += resultMap
    }

    return out
}

private fun write(values: List<Map<String, String>>) {
    names.forEachIndexed { index, baseName ->
        val jsonObject = buildJsonObject {
            val correspondingMap = values[index]
            correspondingMap.forEach { (key, value) ->
                if (value.containsAnyOf(NUMBERS)) {
                    put(key, JsonPrimitive(value.toInt()))
                } else if (value.contains(".")) {
                    put(key, JsonPrimitive(value.toFloat()))
                } else {
                    put(key, JsonPrimitive(value))
                }
            }
        }

        val builder = StringBuilder()
        builder.append(CONFIG_DIR_PATH)
        builder.append(baseName.removeSuffix("\r"))
        builder.append(".config.json")

        FileOutputStream(builder.toString()).use { stream ->
            stream.write(JSON.encodeToString(JsonObject.serializer(), jsonObject).encodeToByteArray())
        }
    }
}

private fun String.containsAnyOf(list: List<Char>): Boolean {
    var result = false

    list.forEach { char ->
        if (contains(char)) result = true
    }

    return result
}
