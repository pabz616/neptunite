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