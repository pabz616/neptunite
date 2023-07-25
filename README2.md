***ESPRESSO WEB VIEW MATCHERS***

### WEB VIEWS

`onWebView().inWindow(Atom<WindowReference>);`
`onWebView().withElement(Atom<ElementReference>);`
`onWebView().withContextualElement(Atom<ElementReference>);`
`onWebView().perform(Atom<Evaluation>);`
`onWebView().check(WebAssertion);`

1. Build the project (pointing to gradle files) and launch the application
2. Use Chrome DevTools to find web elements within the mobile web view (like webdriver)
3. In Android Studio, Write a new test class wit the following:

`
Imports go here ...

public class WebViewActivityTest{
    @Rule
        public ActivityTestRule<WebViewActivity> mActivity = new ActivityTestRule<WebViewActivity>(WebViewActivity.class, false, false){

            @Override
            protected void afterActivityLaunched(){
                onWebView().forceJavascriptEnabled();
            }
        };

    @Test
    public void addTestCase(){
        Intent webFormIntent = new Intent();
        mActivity.launchActivity(webFormIntent);
        
        //INPUT
        onWebView()
            .withElement(findElement(Locator.ID, value))
            .perform(clearElement())
            .perform(DriverAtoms.webKeys("Text"));

        //BUTTON
        onWebView()
            .withElement(findElement(Locator.ID, value))
            .perform(webClick());

        //ASSERTION
        onWebView()
            .withElement(findElement(Locator.ID, value))
            .check(WebMatches(getText(), containsString("substring")));

    }
}
`

***ESPRESSO IDLING RESOURCES***
An idling resource represents an asynchronous operation whose results affect subsequent operations in a UI test. By registering idling resources with Espresso, you can validate these asynchronous operations more reliably when testing your app.

### Uses for Idling Resources

1. Loading data from the internet or a local data source.
2. Establishing connections with databases and callbacks.
3. Managing services, either using a system service or an instance of IntentService.
4. Performing complex business logic, such as bitmap transformations.

CODE SNIPPET:
`
Imports go here

public class TestIdlingResource{
        @Rule public ActivityTestRule<MainActivity> activityTestRule
        = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource myIdling ;

    @Before
    public void registerIdlingResources()
    {
        myIdling = activityTestRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(myIdling);
    }

    @After
    public void unRegisterIdlingResources()
    {
        if (myIdling != null){
            IdlingRegistry.getInstance().unregister(myIdling);
        }
    
    @Test
    //code goes here ...
    }
}
`

***KOTLIN + ESPRESSO***

Similar to android espresso, but with subtle nuances

`
  //IMPORTS GO HERE

  @RunWith(AndroidJUnit4ClassRunner::class)
  class ReminderViewModelTest{

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun getReminders(){
        val reminderName = "TestAA"
        val createReminderBtn = onView(withId(R.id.fab))
        val reminderNameInput = onView(withId(R.id.edReminder))
        val submitReminderBtn = onView(withId(R.id.btnAdd))
        val newReminder = onView(withText(reminderName))

        createReminderBtn.perform(click())
        reminderNameInput.perform(typeText(reminderName))
        closeSoftKeyboard()
        submitReminderBtn.perform(click())
        pressBack()
        newReminder.check(ViewAssertions.matches(isDisplayed()))
    }
  }
`

### ViewMatchers include:

* `onView(withId(R.id.x))`
* `onView(withText(variableName))`
* `onView(withId(R.id.x)).check(ViewAssertions.matches(isDisplayed(Y)))`
* `onView(withId(R.id.x)).check(ViewAssertions.matches(isChecked(Y)))`

These require importing hamcrest matchers (see notes under AdapterView)

* `onView(withId(R.id.x)).check(ViewAssertions.matches(isEqualTo(Y)))`
* `onView(withId(R.id.x)).check(ViewAssertions.matches(isAllOf(Foo)))`
* `onView(withId(R.id.x)).check(ViewAssertions.matches(isAnyOf(Bar)))`

### ViewActions include

* `onView(withId(R.id.x)).perform(click())`
* `onView(withId(R.id.x)).perform(typeText(testData))`
* `onView(withId(R.id.x)).perform(replaceText(testData))`
* `closeSoftKeyboard()`

### ActivityTestRule

Is executed before each test (@BeforeEach)

### Testing AdapterView Items

Consider the likelihood of testing view fragments that have either a ListView, Spinner or some-such items
`
  import org.hamcrest.Matchers.*
  //ALL OTHER IMPORTS GO HERE

  @RunWith(AndroidJUnit4ClassRunner::class)
  classAdapterViewModelTest{

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun selectItem(){
        val menu = onView(withId(R.id.spinnerView))
        val menuItem = onData(allOf(instanceOf(Reminder::class.java), equalTo(ReminderItem("message"))))

        menu.perform(click())
        menuItem.perform(click())

    }
  }
`