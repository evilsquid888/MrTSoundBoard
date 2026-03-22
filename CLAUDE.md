# CLAUDE.md — MrTSoundBoard

## Project Overview

Mr T Soundboard is a legacy Android app that plays Mr. T sound clips when the user taps buttons. It is a simple single-activity soundboard with 12 audio clips (MP3, 22 kHz mono) and an About screen. The app includes Google AdMob banner ads.

Package: `com.clearandvalid.soundboard.mrtfree`

## Tech Stack

- **Language:** Java (Android SDK)
- **Build system:** Gradle (very old — Android Gradle plugin 0.4, Gradle 1.6)
- **Target SDK:** Android API 13 (Honeycomb 3.2)
- **Ads:** Google AdMob SDK 6.4.1 (bundled JAR in `libs/`)
- **IDE metadata:** IntelliJ IDEA / early Android Studio (`.idea/` directory present)

## Project Structure

```
├── AndroidManifest.xml          # App manifest (package, permissions, activities)
├── build.gradle                 # Gradle build config (legacy android plugin 0.4)
├── default.properties           # Android target level (API 13)
├── src/com/clearandvalid/soundboard/mrtfree/
│   ├── MrT.java                 # Main activity — loads sounds, handles button clicks
│   └── About.java               # About screen activity
├── res/
│   ├── layout/
│   │   ├── main.xml             # Main UI — ScrollView with 12 buttons in pairs
│   │   ├── about.xml            # About screen layout
│   │   └── menu.xml             # Options menu (About / Quit)
│   ├── raw/                     # 12 MP3 sound clips (a.mp3 through l.mp3)
│   ├── drawable/                # Background, glossy button, and app icon PNGs
│   └── values/
│       ├── strings.xml          # Button labels and app strings
│       ├── colors.xml           # Color definitions
│       └── styles.xml           # Style definitions
├── libs/
│   └── GoogleAdMobAdsSdk-6.4.1.jar
└── icon.png                     # App icon (high-res)
```

## Build & Run

This project uses a very old Gradle/Android plugin version and will not build with modern tooling without migration. To attempt a build with a compatible environment:

```bash
gradle build
```

In practice, this project would need to be migrated to a current Android Gradle plugin (AGP 8.x+) and updated to use `AndroidX` / modern SDK levels to build with current tools.

## Tests

There are no tests in this project. The `build.gradle` references an `instrumentTest` root at `tests/`, but no test directory or test files exist.

## Architecture Notes

- **MrT.java** is the main (and only real) activity. It pre-loads all 12 `MediaPlayer` instances in `onCreate()` and maps button clicks to sound playback via a `switch` statement in `onClick()`.
- **About.java** is a trivial activity that just sets a content view.
- Sound files are stored as raw resources (`res/raw/a.mp3` through `res/raw/l.mp3`).
- The UI is a `ScrollView` containing a vertical `LinearLayout` with six rows of two buttons each.
- AdMob banner ads are programmatically added to the main layout.

## Coding Conventions

- Single-letter variable names for `MediaPlayer` instances (`a` through `l`), matching raw resource filenames.
- Mixed indentation: spaces and tabs coexist.
- No package-level separation beyond the single `mrtfree` package.
- XML layouts use legacy `fill_parent` (equivalent to `match_parent`).

## Known Issues

- The `build.gradle` contains hardcoded signing keystore paths and passwords — these are non-functional placeholders but should not be treated as real credentials.
- `setContentView(R.layout.main)` is called twice in `MrT.onCreate()`.
- The AdMob publisher ID is hardcoded in `MrT.java`.
- The project targets a very old Android API level and SDK tooling.
