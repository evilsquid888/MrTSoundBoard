# Changelog

## [3.0] - 2026-03-01

Major modernization of the Android project.

### Changed
- Upgraded to Android Gradle Plugin 8.7.3 (was 0.4)
- Upgraded to Gradle 8.9 (was 1.6)
- Updated `compileSdk` to 35 / Android 15 (was 13 / Android 3.0)
- Updated `targetSdk` to 35 (was 13)
- Updated `minSdk` to 24 / Android 7.0 (was 13)
- Updated Java compatibility to Java 17 (was Java 6)
- Migrated to modern Android project structure with `app` module
- Replaced deprecated `fill_parent` with `match_parent` in layouts
- Replaced `px` units with `dp`/`sp` in layouts
- Moved menu XML from `res/layout/` to `res/menu/`
- Modernized `onClick` handling from `switch` to `if-else` (R fields are no longer compile-time constants)
- Updated `AndroidManifest.xml` with `android:exported` attributes (required by API 31+)
- Applied `Theme.Material.Light.NoActionBar` theme

### Added
- `settings.gradle` with plugin and dependency repository management
- `gradle.properties` with AndroidX and non-transitive R class settings
- `build.sh` script for manual APK builds without Gradle
- `proguard-rules.pro` for release builds
- `.gitignore` for standard Android project
- `README.md`
- `CHANGELOG.md`

### Removed
- Google AdMob SDK dependency (legacy `com.google.ads` jar)
- Eclipse project files (`.classpath`, `.project`)
- `default.properties` (replaced by `build.gradle` config)
- Hardcoded signing configurations with plaintext passwords
- `libs/` directory with bundled jar

## [2.1] - 2013-07-09

### Changed
- Initial Gradle build setup (Gradle 1.6, AGP 0.4)

## [2.0] - 2009-01-01

### Added
- Initial release with 12 Mr. T sound clips
- Scrollable button grid layout
- About screen
- Google AdMob ad integration
