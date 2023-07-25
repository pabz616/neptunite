***ESPRESSO USING PAGE OBJECT MODELING***

Given a project where tests are using the same functions, move them over to a new package and import them accordingly

1. Under the test directory, create a package called `pageobject` (or whatever))
2. Add a new test class named for something relevant to the tests, import `pageobject`
3. If using @RULE - called `RuleName`, the test class to use is className extends RuleName
4. Name any associated variable in the following way: `private final int item = R.id.itemId`
5. Set up the method so it looks something like this:

```
import static org.hamcrest.core.AllOf.allOf;

public class CoolMethod{
    //VARIABLES GO HERE

    private final int textInput = onView(withId(R.id.inputId));
    private final int textInput2 = onView(withId(R.id.inputId2));
    private final int button = onView(withId(R.id.buttonId));

    public void ActionTaken(String value, String value2){

        textInput.perform(scrollTo(), typeText(value));
        textInput2.perform(scrollTo(), typeText(value2));
        button.perform(click())

        intended(allOf(
            hasAction(equalTo(Intent.ACTION_SENDTO)),
            hasExtra(Intent.EXTRA_SUBJECT, "Cool statement"+value1+"and"+value2+"")));

    }
}
```

6. To use the method in test, set it as `private JavaClassName coolPOM = new  JavaClassName();`
7. Call the method and it's actions like this: `coolPOM.CoolMethod();`
8. The complete picture is:

```
//IMPORTS GO HERE

@RunWith(AndroidJUnit4.class)
public class AwesomeTest extends TestBase{
    private JavaClassName coolPOM = new  JavaClassName();

    @Test
    public void AwesomeTestCase(){
        coolPOM.CoolMethod();
    }
}
```
