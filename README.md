# Mr T Soundboard

An Android soundboard app featuring 12 classic Mr. T audio clips. Tap a button, hear the man.

## Sounds

| Button | Clip |
|--------|------|
| 1 | "Get out of my way" |
| 2 | "How about this" |
| 3 | "Teach a lesson" |
| 4 | "Mind your business" |
| 5 | "People never learn" |
| 6 | "No, fool" |
| 7 | "Pity the fool" |
| 8 | "Shutup fool" |
| 9 | "What this fool" |
| 10 | "You tricked me" |
| 11 | "Just a crazy man" |
| 12 | "My business" |

## Requirements

- Android SDK (API 35 / Android 15)
- Java 17+
- Gradle 8.9+

## Building

### With Gradle

```bash
./gradlew assembleDebug
```

The APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

### Without Gradle (manual build)

A `build.sh` script is included for environments where Gradle cannot reach Google Maven (e.g. offline/sandboxed builds):

```bash
./build.sh
```

The APK will be at `build/app-debug.apk`.

## Project Structure

```
app/
  src/main/
    java/com/clearandvalid/soundboard/mrtfree/
      MrT.java          # Main activity - soundboard buttons
      About.java         # About screen
    res/
      layout/            # UI layouts
      menu/              # Options menu
      raw/               # MP3 audio clips (a.mp3 - l.mp3)
      drawable/          # Icons and backgrounds
      values/            # Strings, colors, styles
    AndroidManifest.xml
```

## SDK Targets

| Property | Value |
|----------|-------|
| `compileSdk` | 35 |
| `targetSdk` | 35 |
| `minSdk` | 24 |
| `versionName` | 3.0 |
| `versionCode` | 5 |

## License

Written by Garrett Neuenkirchen, January 2009.
