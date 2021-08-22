# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v0.2] - 2021-08-21

### Added

- New fluid-handling system
  - Rancid variants
  - [Dehydration](https://github.com/Globox1997/Dehydration) integration and dependency
  - ItemNBT integration and other improvements
- 70 remaining foods from Croptopia

### Changed

- Rework the item NBT system to make it more flexible and put it [here](https://github.com/RedGrapefruit09/ItemNBT)
- Rework the `FoodConfig` system to import data-driven JSON files with an event-based lazy loader system
- Migrated old fluids to the new fluid-handling system
- Bundle Fabric API & Fabric Language Kotlin

## [v0.1] - 2021-08-10

### Added

- Realism Core
    - Food rot
    - Food overdue
    - Rotten variants
    - Overdue variants
    - Salted variants
    - Custom colorful tooltips
- Patching system that injects into already-existing items (including from other mods)
- 150 covered food items from Croptopia.
