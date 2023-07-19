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
   
## ESPRESSO PRO-TIP

When building an application, if you get the `Kotlin duplication ..` error, simply
open build.gradle(Module:app) and add the following line to the end:
```configurations.implementation {
    exclude group: 'org.jetbrains.kotlin', module: 'kotlin-stdlib-jdk8'
}
```
... then rebuild the project

## ESPRESSO DECLARATION

`private static final String myText = "my text";`
replace String with proper data type

## ESPRESSO FIND ELEMENT LOCATORS

Launch the application in your emulator then:
`Tools > Layout Inspector > Attributes`

As you navigate through the app, the screens will be reflected in the layout inspector window
This allows you to interact with the elements shown and find their respective ids

## ESPRESSO TEST COMPOSITE

`@Test`
   `public void descriptiveTestName(){ ... arrange / act / assert ...}`

## ESPRESSO VIEW MATCHERS

*** ESPRESSO VIEW MATCHERS ***

### USING RESOURCE ID

`ViewInteraction test = onView(withId(R.id.someId));`

### USING VISIBLE TEXT

`ViewInteraction done = onView(withText("Done"));`

### USING CONTENT DESCRIPTION

`ViewInteraction profile = onView(withContentDescription("profile"));`

### USING HINT TEXT

`ViewInteraction hint = onView(withHint("Simple hint"));`

### USING SPINNER TEXT

`ViewInteraction spinnerText = onView(withSpinnerText("Spinner_Text"));`

### USING LINKS

`ViewInteraction linkName = onView(hasLinks(##));`

## OBJECT MATCHERS

`onView(withClassName(endsWith("EditText")));`
`onView(withClassName(startsWith("Hello")));`

*** DATA / LIST ADAPTER VIEW

### Data is used in case of ListView, GridView and AdapterView

`onData(withId("Listview_id")).atPosition(2).check(matches(isDisplayed()));`

## ESPRESSO COMMON ACTIONS

### Typing inside a textbox

`onView(withText("name")).perform(typeText("sample text"));`
`onView(withText("search")).perform(typeTextIntoFocusedView("sample text"));`

### Clearing text inside an input

`onView(withText("name")).perform(clearText());`

### Clicking a button

`onView(withText("submit")).perform(click());`

### Double-Clicking a button

`onView(withText("submit")).perform(doubleClick());`

### Long press a button

`onView(withText("submit")).perform(longClick());`

### Swipe + direction (UP, DOWN, LEFT, RIGHT)

`onView(withId(R.id.sampleView)).perform(swipeUp());`
`onView(withId(R.id.sampleView)).perform(swipeDown());`
`onView(withId(R.id.sampleView)).perform(swipeLeft());`
`onView(withId(R.id.sampleView)).perform(swipeRight());`

### SCROLL LIST VIEW

`onView(withId(R.id.listView)).perform(scrollTo());`
`onView(withId(R.id.listView)).perform(scrollTo(), click());`

## ESPRESSO DEVICE ACTIONS

### CLOSE SOFT KEYBOARD

`closeSoftKeyboard();`

### NAVIGATE BACK ON DEVICE

`pressBack();`

### OPEN PHONE SPECIFIC MENU

`pressMenuKey();`

### PRESS A SPECIFIC KEY

`keycodepressKey(37);`

### OPEN LINK IN BROWSER

`let url = 'https://www.google.com`
`onView(withText(url)).perform(openLinkWithText(url));`

*** ESPRESSO COMMON ASSERTIONS ***

### CHECK ELEMENT IS DISPLAYED

`onView(withId(R.id.anyElement)).check(matches(isDisplayed()));`

### CHECK ELEMENT IS REMOVED FROM DOM

`onView(withId(R.id.anyElement)).check(doesNotExist());`

### CHECK ELEMENT STRING VALUE

`onView(withId(R.id.anyString)).check(matches(withText(R.string.custom_string)));`

### CHECK ELEMENT TEXT

`onView(withId(R.id.anyText)).check(matches(withText("custom string")));`

### CHECK POSITION OF ELEMENT

`onView(withId(R.id.textView)).check(isLeftOf(withText("foo!")));`
`onView(withId(R.id.textView)).check(isRightOf(withText("foo!")));`
`onView(withId(R.id.textView)).check(isAbove(withText("foo!")));`
`onView(withId(R.id.textView)).check(isBelow(withText("foo!")));`

### CHECK ACTION OF ELEMENT THAT REQUIRES USER INTERACTION

`onView(withId(R.id.anyInput)).check(matches(isFocusable()));`
`onView(withId(R.id.button)).check(matches(isClickable()));`
`onView(withId(R.id.checkbox)).check(matches(isNotChecked()));`

***ESPRESSO CUSTOM MATCHER***
Use when the UIAutomator is not working. To do so, do the following:

1. In the project structure: `app > src > androidTest > java` create a new package with something descriptive like "x.espress.errormatcher"
2. Add a New Class like "ErrorTextMatcher"
3. In the file, add different parameters to suit your needs (Plain Text, String Matcher, and Resource ID)

### CUSTOM MATCHER 1 - USING PLAIN TEXT

`onView(withId(R.id.Element)).check(matches(CustomMatcher.withWhatever("myText")));`

### CUSTOM MATCHER 2 - USING ID

`onView(withId(R.id.Element)).check(ViewAssertion.matches(CustomMatcher.withWhatever(R.string.id)));`

### CUSTOM MATCHER 3 - USING STRING MATCHER

`onView(withId(R.id.Element)).check(ViewAssertion.matches(CustomMatcher.withWhatever(Matcher.containsString("my string"))));`
