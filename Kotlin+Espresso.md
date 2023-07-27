# KOTLIN WITH ESPRESSO

Given the likelihood of an application developed using Kotlin, the test will look slightly different
**Kotlin-Espresso Tests should be created as Kotlin Classes (you can highlight the class, right-click and generate 'Test')
**just remember to have all the espresso dependencies installed
**always refer to the layout inspector for element ids
** visit <https://github.com/pabz616/neptunite/blob/main/SAMPLETESTS.md> for additional tests

```
//IMPORTS GO HERE
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class NameOfActivityTest{
    @get:Rule var activityScenarioRule = activityScenarioRule<NameOfActivity>()

    @Test
    fun checkActivityVisibility() {
        myActivity =  onView(withId(R.id.whatever))
        myActivity.check(matches(isDisplayed()))

    @Test
    fun checkButtonVisibility() {
        myButton = onView(withId(R.id.button))
        myButton.check(matches(isDisplayed()))

    }

        //TO NAVIGATE BACK
        Espresso.pressBack()
    }
}

```

To run ALL the tests classes as a test suite, create a Kotlin Class  (under AndroidTest directory)

```
package com.coolpackagename.uitest

import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivity::class, SecondActivityTest::class, ..)
class ActivityTestSuite

```
