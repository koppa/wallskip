# Wallskip

A minimal Android app with no launcher icon. It registers as a share-sheet target for `text/plain` content and opens the shared URL/text in [archive.is](https://archive.is) to bypass paywalls.

## How it works

1. User shares a URL (or any text) from any app via Android's share sheet
2. Wallskip receives the `ACTION_SEND` intent with `EXTRA_TEXT`
3. Opens `https://archive.is/newest/$sharedText` in the default browser
4. Activity finishes immediately — no UI is shown (transparent theme)

## Build

```sh
./gradlew assembleDebug
```

The APK is at `app/build/outputs/apk/debug/app-debug.apk`.

## Install

```sh
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Test

```sh
adb shell am start -a android.intent.action.SEND -t "text/plain" \
  -e android.intent.extra.TEXT "https://example.com" com.wallskip.app
```

## Project structure

```
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/wallskip/app/ShareReceiverActivity.kt
│       └── res/values/
│           ├── strings.xml
│           └── themes.xml
├── build.gradle.kts
├── gradle/wrapper/
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## Requirements

- Android SDK 24+
- Java 17+
- Gradle 8.5 (via wrapper)
