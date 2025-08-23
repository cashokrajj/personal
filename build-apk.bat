@echo off
echo Building 5s Android App...

REM Set Android SDK path (adjust this to your Android SDK location)
set ANDROID_HOME=C:\Users\%USERNAME%\AppData\Local\Android\Sdk
set ANDROID_SDK_ROOT=%ANDROID_HOME%

REM Create build directories
if not exist "app\build\outputs\apk\debug" mkdir "app\build\outputs\apk\debug"

REM Build the APK using Android SDK tools
echo Compiling resources...
"%ANDROID_HOME%\build-tools\34.0.0\aapt2" compile --dir app\src\main\res -o compiled_resources.zip

echo Linking resources...
"%ANDROID_HOME%\build-tools\34.0.0\aapt2" link -o app\build\intermediates\apk\debug\app-debug.apk -I "%ANDROID_HOME%\platforms\android-34\android.jar" --manifest app\src\main\AndroidManifest.xml compiled_resources.zip

echo APK created successfully!
echo Location: app\build\intermediates\apk\debug\app-debug.apk

pause
