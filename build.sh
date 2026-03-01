#!/bin/bash
# Manual Android APK build script
# Builds the MrT Soundboard APK without Gradle (since Google Maven is unreachable)
set -e

# Configuration
SDK_DIR=/usr/lib/android-sdk
BUILD_TOOLS=$SDK_DIR/build-tools/29.0.3
PLATFORM=$SDK_DIR/platforms/android-23/android.jar
AAPT2=$BUILD_TOOLS/aapt2
ZIPALIGN=$BUILD_TOOLS/zipalign

APP_DIR=app/src/main
SRC_DIR=$APP_DIR/java
RES_DIR=$APP_DIR/res
MANIFEST=$APP_DIR/AndroidManifest.xml

BUILD_DIR=build
GEN_DIR=$BUILD_DIR/gen
OBJ_DIR=$BUILD_DIR/obj
APK_DIR=$BUILD_DIR/apk

# Clean
rm -rf $BUILD_DIR
mkdir -p $GEN_DIR $OBJ_DIR $APK_DIR $BUILD_DIR/compiled_res

echo "=== Step 1: Compile resources with aapt2 ==="
$AAPT2 compile --dir $RES_DIR -o $BUILD_DIR/compiled_res/

echo "=== Step 2: Link resources and generate R.java ==="
$AAPT2 link \
  --proto-format \
  -o $BUILD_DIR/app.ap_ \
  -I $PLATFORM \
  --manifest $MANIFEST \
  --java $GEN_DIR \
  --auto-add-overlay \
  $BUILD_DIR/compiled_res/*.flat

# Also link for the APK (non-proto for final APK)
$AAPT2 link \
  -o $BUILD_DIR/app-res.apk \
  -I $PLATFORM \
  --manifest $MANIFEST \
  --auto-add-overlay \
  $BUILD_DIR/compiled_res/*.flat

echo "=== Step 3: Compile Java sources ==="
# Find all Java source files
find $SRC_DIR -name "*.java" > $BUILD_DIR/sources.txt
echo "$GEN_DIR/com/clearandvalid/soundboard/mrtfree/R.java" >> $BUILD_DIR/sources.txt

javac \
  --release 8 \
  -classpath $PLATFORM \
  -d $OBJ_DIR \
  @$BUILD_DIR/sources.txt \
  2>&1

echo "=== Step 4: Convert to DEX ==="
dalvik-exchange --dex --output=$BUILD_DIR/classes.dex $OBJ_DIR

echo "=== Step 5: Build APK ==="
# Start from the resource APK
cp $BUILD_DIR/app-res.apk $BUILD_DIR/app-unsigned.apk

# Add classes.dex to the APK
cd $BUILD_DIR
jar -uf app-unsigned.apk classes.dex
cd ..

echo "=== Step 6: Create debug keystore ==="
if [ ! -f $BUILD_DIR/debug.keystore ]; then
  keytool -genkeypair \
    -dname "CN=Android Debug,O=Android,C=US" \
    -keystore $BUILD_DIR/debug.keystore \
    -storepass android \
    -keypass android \
    -alias androiddebugkey \
    -keyalg RSA \
    -keysize 2048 \
    -validity 10000
fi

echo "=== Step 7: Zipalign ==="
$ZIPALIGN -f 4 $BUILD_DIR/app-unsigned.apk $BUILD_DIR/app-aligned.apk

echo "=== Step 8: Sign APK ==="
$BUILD_TOOLS/apksigner sign \
  --ks $BUILD_DIR/debug.keystore \
  --ks-pass pass:android \
  --key-pass pass:android \
  --ks-key-alias androiddebugkey \
  --out $BUILD_DIR/app-debug.apk \
  $BUILD_DIR/app-aligned.apk

echo ""
echo "=== BUILD SUCCESSFUL ==="
echo "APK: $BUILD_DIR/app-debug.apk"
ls -la $BUILD_DIR/app-debug.apk
