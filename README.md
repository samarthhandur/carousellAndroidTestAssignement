
# Carousell Automation Assignment (Java)

## Project Structure

```
build.gradle
gradlew
settings.gradle
src
└── test
    └── java
        └── com
            └── carousell
                └── helper
                    ├── AppiumAndroidBase.java : Base class with driver config
                    ├── Utils.java : Utlity functions with super driver
                ├── pages   
                    └── AddItemForSellPageObject.java : Class for Adding items for listing
                    ├── ListingVerificationPageObject.java : Class for Verifying item listing
                    ├── LoginPageObject.java : Class for logging in
                ├── tests
                    ├── StartupTest.java : Simple App startup test                 
```

Libraries:

- JUnit 4
- Appium java-client 6.0.0


## Requirements

- Android Studio: for AVD Manager or a real Android device
- npm: for installing Appium

## Setup

#### Android Device and APK

Install the APK on the device with adb:

```
adb install Carousell-Android-App.apk
```

You should see a `Success` message and see the Carousell App icon on the Android
launcher app drawer.

#### Appium

Install Appium for the CLI

```
npm install -g appium
```

#### Java

Follow the required Java instructions for your operating system.

Be sure to install Java 8 or newer.

#### Start the tests

Start Appium in the background (you should leave it running):

```
appium
```

In another terminal, run the test suite:

```
./gradlew clean test
```

If successful, you should see the device load the Carousell App and then see tests started running
