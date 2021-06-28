# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v0.1-preview.10] (2021-06-28)

### Added

- **[REALISM]** Patch coverage for:
    - Molasses
    - Mustard
    - Nectarine
    - Noodle
    - Nougat
    - Nutmeg
    - Nutty Cookie
    - Oat
    - Oatmeal
    - Olive
    - Olive Oil
    - Onion
    - Onion Rings
    - Orange
    - Orange Juice

### Changed

- Internal fixes and optimizations
- Use the newest Patchouli snapshot
- Use the canonical Croptopia instead of CroptopiaRed

### Removed

- Chives support in favor of using canon Croptopia

## [v0.1-preview.9] (2021-06-26)

### Added

- **[REALISM]** Patch coverage for:
    - Kumquat
    - Leafy Salad
    - Leek
    - Leek Soup
    - Lemon
    - Lemon Chicken
    - Lemonade
    - Lettuce
    - Lime
    - Limeade
    - Mango
    - Mango Ice Cream
    - Mead
    - Melon Juice
    - Milk Bottle

### Changed

- **[CORE]** Update Kotlin from `1.5.10` to `1.5.20`
- **[CORE]** Update FLK from `1.6.1+kotlin.1.5.10`

### Fixed

- **[REALISM]** Missing lang entries

## [v0.1-preview.8] (2021-06-25)

### Added

- **[REALISM]** Patch coverage for:
    - Ginger
    - Grape
    - Grape Jam
    - Grapefruit
    - Greenbean
    - Greenonion
    - Grilled Cheese
    - Ham Sandwich
    - Hamburger
    - Honeydew
    - Hops
    - Horchata
    - Kale
    - Kale Chips
    - Kale Smoothie
    - Kiwi

### Changed

- **[REALISM]** Reworked the patch system to work like a managed query:
    - `Patch` - a `data class` containing info about a patch
    - `PatchSystem` - an `object` containing a managed query appended using `patch(...)` and executed using `apply()`
    - `PatchRegistry` - an `object` containing all patches
    - `Either` - a utility `data class` containing either `TFirst` or `TSecond`
- **[REALISM]** Renamed category `PRODUCT` to `HUMAN_MADE`
- **[CORE]** Increase Gradle memory
- **[CORE]** Update Gradle from `7.0.2` to `7.1`

### Fixed

- **[REALISM]** Incorrect recipes
- **[REALISM]** Incorrect models

## [v0.1-preview.7] (2021-06-22)

### Added

- **[REALISM]** Patch coverage for:
    - Eggplant
    - Elderberry
    - Elderberry Jam
    - Enchilada
    - Eton Mess
    - Fajitas
    - Fig
    - Figgy Pudding
    - Fish and Chips
    - Flour
    - French Fries
    - Fried Chicken
    - Fruit Salad
    - Fruit Smoothie
    - Garlic
- **[FORK]** Chives to the curated fork of Croptopia
- **[REALISM]** Missing `saltEfficiency` parameter

### Changed

- **[REALISM]** Improve `FridgeState` serialization
- **[REALISM]** Improve patch target discovery
- **[CORE]** Exclude Croptopia reference textures from the output JAR to reduce size

### Removed

- **[REALISM]** Donut in favor of doughnut

## [v0.1-preview.6] (2021-06-21)

### Added

- **[REALISM]** Patch coverage for:
    - Coffee Beans
    - Corn
    - Cornish Pasty
    - Cranberry
    - Cranberry Juice
    - Crema
    - Cucumber
    - Cucumber Salad
    - Currant
    - Date
    - Donut
    - Dough
    - Doughnut
    - Dragonfruit
    - Egg Roll

### Changed

- **[CORE]** Update Fabric API from ```0.35.2+1.17``` to ```0.36.0+1.17```

## [v0.1-preview.5] (2021-06-18)

### Added

- **[REALISM]** Patch coverage for:
    - Cherry
    - Cherry Jam
    - Cherry Pie
    - Chicken and Dumplings
    - Chicken and Noodles
    - Chicken and Rice
    - Chile Pepper
    - Chili Relleno
    - Chimichanga
    - Chives
    - Chocolate
    - Chocolate Milkshake
    - Cinnamon
    - Coconut
    - Coffee

### Changed

- **[CORE]** Updated Yarn from ```1.17+build.12``` to ```1.17+build.13```

## [v0.1-preview.4] (2021-06-17)

### Added

- **[REALISM]** Patch coverage for:
    - Cabbage
    - Caesar Salad
    - Candied Nuts
    - Candy Corn
    - Caramel
    - Cantaloupe
    - Carnitas
    - Cashew
    - Cashew Chicken
    - Cauliflower
    - Celery
    - Cheese
    - Cheese Cake
    - Cheese Pizza
    - Cheeseburger

### Changed

- **[CORE]** Update Fabric Loader from ```0.11.3``` to ```0.11.6```
- **[CORE]** Update Fabric API from ```0.35.1+1.17``` to ```0.35.2+1.17```
- **[CORE]** Update Yarn mappings from ```1.17+build.11``` to ```1.17+build.12```
- **[CORE]** Minor cleanup and refactoring

### Removed

- **[CORE]** The YouTrack page in favor of Trello

## [v0.1-preview.3] (2021-06-14)

### Added

- **[CORE]** YouTrack (InCloud) page [here](https://redgrapefruit.myjetbrains.com/youtrack/issues)
- **[REALISM]** Patch coverage for:
    - Basil
    - Beef Jerky
    - Beef Wellington
    - Bellpepper
    - Blackbean
    - Blackberry
    - Blackberry Jam
    - BLT
    - Blueberry
    - Blueberry Jam
    - Broccoli
    - Brownies
    - Burrito
    - Butter
    - Buttered Toast

### Changed

- **[CORE]** Update Fabric API from ```0.34.9+1.17``` to ```0.35.1+1.17```
- **[CORE]** Update Yarn mappings from ```1.17+build.6``` to ```1.17+build.11```

### Removed

- **[CORE]** The module system and ```utopia.modules.json``` config

## [v0.1-preview.2] (2021-06-10)

### Added

- **[CORE]** 1.17 support!
- **[CORE]** Fabric API as a bundled dependency - you don't have to install it anymore

### Changed

- **[CORE]** Use Croptopia 1.17-rc2 build
- **[CORE]** Use Patchouli snapshot build

### Removed

- **[CORE]** Some dependencies temporarily until they update to 1.17:
  - Dehydration
  - Sodium
  - Lithium
  - Phosphor

## [v0.1-preview.1] (2021-06-10)

### Added

- **[CORE]** A flexible module system allowing you to turn different modules on/off in ```config/utopia.modules.json```
- **[REALISM]** Food system:
    - Rot effect
    - Overdue effect
    - Salted food to reduce rot and overdue speed
    - Item tooltips displaying all the necessary food stats
    - Mixin implementation for pre-existing food
    - Patching system that applies the mixin changes
- **[REALISM]** Patch coverage for:
    - Almond
    - Almond Brittle
    - Apple Juice
    - Apple Pie
    - Apricot
    - Apricot Jam
    - Artichoke
    - Artichoke Dip
    - Asparagus
    - Avocado
    - Baked Beans
    - Banana
    - Banana Cream Pie
    - Banana Nut Bread
    - Barley
- **[FURNITURE]** A renewed Container API for menu blocks
- **[FURNITURE]** A fridge block allowing to reduce overdue & rot speed