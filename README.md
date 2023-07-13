# neptunite
A mineral named for Neptune, Roman god of the sea because of its association with aegirine from Àgir, the Scandinavian sea-god

## POC - Android / Espresso
This is a sample test framework for android, work-in-progress

## Requirements
* JAVA JDK v. 8, verify w. the command `java -version`
* Gradle 6.3, verify w. the command `gradle -v`
* Android Studio 3.6.1
  * Android SDK
  * Adroid AVD
* Android Emulator w. Android SDK 9.0(API Level +28)

## Virtual Device Setup
* Use the Device manager and set up a device based on current Android API

## Physical Device Setup
1. Connect the device to your machine using USB cable
2. Enable developer options and USB debugging
   * If Android 9 (API Level 28) and Android, go to `Settings > About Phone > Build Number`
3. Avoid flakiness with devices during testing by turning off system animations. Disable the following in `Settings > Developer > Options`:
   * Window animation scale
   * Transition animation scale
   * Animator duration scale
  
