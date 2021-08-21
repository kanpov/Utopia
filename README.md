# About

This mod builds upon Croptopia to improve the food experience for Minecraft players.  
It is built using Fabric Loader & API and runs on Minecraft 1.17.1 _only_.

Utopia has many unique features:
1. Realism (in development):
    - Rot and overdue
    - Food tooltips
    - Patches to cover food from Minecraft, Croptopia and (optional) Sandwichable
    - Salt and fridges to reduce rot and overdue speeds
2. Furniture (Planned)
3. Building (Planned)
4. Cooking (Planned)
5. Exploration (Planned)

# Install

### Automatic

The releases (and pre-releases) of this mod are available via the automatic [MiniManager tool](https://github.com/RedGrapefruit09/MiniManager).\
Download the installer for your OS, run it, then run the app and click on `Download` in the `Utopia` section.\
The files will be in your folder of choice.

### Manual

There are currently two ways to download the mod's JAR manually: [GitHub releases](https://github.com/RedGrapefruit09/Utopia/releases) and [the Archive](https://github.com/RedGrapefruit09/Archive).\
After release, [CurseForge](https://curseforge.com) and [ModRinth](https://modrinth.com) will be available, too.

Put the JAR in your Minecraft environment's `mods` folder.

**Important**: This mod has 3 mandatory dependencies that you'll need to run it:
1. [Croptopia](https://github.com/ExcessiveAmountsOfZombies/Croptopia) - the foundation mod
2. [Dehydration](https://github.com/Globox1997/Dehydration) - the thirst mod acting as a base for mod's fluids
3. [Patchouli](https://github.com/https://github.com/VazkiiMods/Patchouli) - the questbook mod used to unlock Utopia & Croptopia's questbooks
All of them have to be manually downloaded and updated whenever it is needed, which is why the automatic installation type is preferred.

# Compile

If you want the most recent (and untested) features of the mod at hand, you can compile it.

Download the ZIP file of the repo, extract it somewhere, open CLI in that folder and type this command.\
For Windows: `gradlew build`.\
For Unix (Linux and Mac OS X): `./gradlew build`

# Roadmap

The full state of the development is available on [the official Trello board](https://trello.com/b/jwybJXPQ/utopia).

This project's quite big and will probably not be finished this year.\
The very early (and yet to change) release date is Spring 2022.

Here's a roadmap of the pre-releases:

**0.1 - Realism, Part 1** - Available on all 3 platforms\
**0.2 - Realism, Part 2** - Available on all 3 platforms\
**0.3 - Furniture & Storage** - 20th September 2021\
**0.4 - Building** - Unknown\
**0.5 - Cooking, Part 1** - Unknown\
**0.6 - Cooking, Part 2** - Unknown\
**0.7 - World Generation** - Unknown\
**0.8 - The Final Boss** - Unknown\
**0.9 - Patching Up** - Unknown\
**1.0 - Release** - Spring or Summer 2022

# Code

The code is mainly written in Kotlin 1.5.21, except for mixins, which are written in Java 16.
I try to comment and document the code as much as I can to ensure readability.  
Any refactoring and cleanup suggestions are welcome!

# Contribute

Any contributions (PRs and issues) are welcome.  
All contributors will be **credited** in the mod when pressing the ```/utopia``` command in-game.
