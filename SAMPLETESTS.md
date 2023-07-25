## SAMPLES

```
   @Test
    public void testTextInput(){
        /* TEST NAME INPUT */
        ViewInteraction nameInput = onView(withId(R.id.name));

        nameInput.check(matches(isDisplayed()));
        nameInput.check(matches(isFocusable()));
        nameInput.perform(clearText());
        nameInput.check(matches(withText(isEmpty)));
        nameInput.perform(typeText("Yoda"));
        nameInput.check(matches(withText(expectedName)));
//        nameInput.check(ViewAssertions.matches(ErrorTextMatchers.withErrorText("this field is required")));
    }

    @Test
    public void testAddressInput(){
        /* TEST ADDRESS INPUT INPUT */
        ViewInteraction addressInput = onView(withId(R.id.address));

        addressInput.check(matches(isDisplayed()));
        addressInput.check(matches(isFocusable()));
        addressInput.check(matches(withText(isEmpty)));
        addressInput.perform(typeText("123 Dagobah Place, Swamp City, Dagobah"));
        addressInput.check(matches(withText(expectedAddress)));
    }

    @Test
    public void testPhoneNumberInput(){
        /* TEST PHONE NUMBER INPUT */
        ViewInteraction phoneNumberInput = onView(withId(R.id.phone));

        phoneNumberInput.check(matches(isDisplayed()));
        phoneNumberInput.check(matches(isFocusable()));
        phoneNumberInput.check(matches(withText(isEmpty)));
        phoneNumberInput.perform(typeText("2123334455"));
        phoneNumberInput.check(matches(withText(expectedPhoneNumber)));
    }

    @Test
    public void testEmailAddressInput(){
        /* TEST EMAIL ADDRESS INPUT */
        ViewInteraction emailAddressInput = onView(withId(R.id.emailAddress));

        emailAddressInput.check(matches(isDisplayed()));
        emailAddressInput.check(matches(isFocusable()));
        emailAddressInput.check(matches(withText(isEmpty)));
        emailAddressInput.perform(typeText("yoda@jediacademy.org"));
        emailAddressInput.check(matches(withText(expectedEmail)));
    }

    @Test
    public void testDateInput(){
        /* TEST DATE INPUT */
        ViewInteraction dateInput = onView(withId(R.id.date));

        dateInput.check(matches(isDisplayed()));
        dateInput.check(matches(isFocusable()));
        dateInput.check(matches(withText(isEmpty)));
        dateInput.perform(typeText("06/16/1975"));
        dateInput.check(matches(withText(expectedDate)));
    }

    @Test
    public void testRadioInput(){
        /* TEST RADIO BUTTONS INPUT */
        ViewInteraction select_Male = onView(withId(R.id.gender_m));
        ViewInteraction select_Female = onView(withId(R.id.gender_f));

        select_Male.check(matches(isDisplayed()));
        select_Male.check(matches(isFocusable()));
        select_Male.check(matches(isClickable()));
        select_Male.check(matches(isNotChecked()));
        select_Male.check(matches(withText(radioInputLabel_M)));
        select_Male.perform(click());

        select_Female.check(matches(isDisplayed()));
        select_Female.check(matches(isFocusable()));
        select_Female.check(matches(isClickable()));
        select_Female.check(matches(isNotChecked()));
        select_Female.check(matches(withText(radioInputLabel_F)));
    }

    @Test
    public void testToggle(){
        /* TEST TOGGLE SWITCH INPUT */
        ViewInteraction toggle = onView(withId(R.id.switch1));

        toggle.check(matches(isDisplayed()));
        toggle.check(matches(isFocusable()));
        toggle.check(matches(isClickable()));
        toggle.check(matches(withText(toggleIputLabel)));
        toggle.perform(click());
    }

    @Test
    public void testCheckbox(){
        /* TEST CHECKBOX INPUT */
        ViewInteraction checkbox = onView(withId(R.id.checkBox));

        checkbox.check(matches(isDisplayed()));
        checkbox.check(matches(isFocusable()));
        checkbox.check(matches(isNotChecked()));
        checkbox.check(matches(withText(agreementCopy)));
        checkbox.perform(click());
        checkbox.check(matches(isChecked()));
    }

    @Test
    public void testButton(){
        /* TEST BUTTON */
        ViewInteraction submitButton = onView(withId(R.id.submit));

        submitButton.check(matches(isDisplayed()));
        submitButton.check(matches(isFocusable()));
        submitButton.check(matches(isClickable()));
        submitButton.check(matches(withText("Submit")));
        submitButton.perform(click());
    }

    @Test
    public void testToastMessage(){
        /* TEST TOAST INPUT */
        ViewInteraction showToast = onView(withId(R.id.fab));
        ViewInteraction toast = onView(withText(toastMessage));

        showToast.check(matches(isDisplayed()));
        showToast.check(matches(isFocusable()));
        showToast.check(matches(isClickable()));
        showToast.perform(click());
        toast.check(matches(isDisplayed()));
    }
```
