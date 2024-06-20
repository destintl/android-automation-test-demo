## [Local Run] Installation

### Install - Depedencies

- Install HomeBrew
  ```
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
  ```
- Install Node
  ```
  brew install node
  ```
- Install [NPM](https://www.npmjs.com/)
- Install [Appium 2](https://appium.github.io/appium/docs/en/2.0/intro/)
  ```
  npm install -g appium@next
  ```
- Install appium driver for tests
  ```
  appium driver install xcuitest
  ```
  ```
  appium driver install uiautomator2
  ```
- Install [Java](https://www.oracle.com/id/java/technologies/javase/javase8-archive-downloads.html) (JDK)
  ```
  brew install openjdk@11
  ```
- Install [Maven](https://maven.apache.org/)
  ```
  brew install maven
  ```

### Install - Android

- Install [Android Studio](https://developer.android.com/studio)
- Install some devices in android (AVD)
- Export $ANDROID_HOME (set path for ANDROID_HOME), `make sure adb detected`
- [optional] Install ADB
  ```
  brew cask install android-platform-tools
  ```

### Install - Appium Inspector
- Install [Appium Inspector](https://github.com/appium/appium-inspector/releases)





#### Login Demo
https://github.com/destintl/android-automation-test-demo/assets/133567369/468620c1-95d6-4ddc-be45-321ba033be65


#### Register Demo
https://github.com/destintl/android-automation-test-demo/assets/133567369/05accf2d-6334-4d19-aacf-7e0a0acfbe1b

