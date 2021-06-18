# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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