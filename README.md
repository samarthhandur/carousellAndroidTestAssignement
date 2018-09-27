
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

#### Automation flow
If successful, you should see the device load the Carousell App and then see tests started running for the below mentioned flow:

1. Launch the application
2. Click on Login Button
3. Reject Single Sign On pop 
4. Enter valid credentials and click on Log in
5. Click on Sell button
6. Add the images for item on "What you are listing today?" page and click NEXT.
7. Scroll down over Category page until 'Everything Else' and click.
8. Click 'MISCELLENOUS'
9. Add listing name as 'CarousellTest'.
10. Enter price as 25.
11. Submit the listing
12. Skip the list sharing by clicking 'MAY BE NEXT TIME' button.
13. Go to BROWSE screen
14. Click on 'See All'
15. Scroll down until 'Everything Else' appears and click.
16. Assert the item name from step #9 equals to the first item name text.

