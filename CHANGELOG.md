# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v0.1-preview.2] (2021-06-10)

### Added

- **[CORE]** Beta 1.17 support!
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