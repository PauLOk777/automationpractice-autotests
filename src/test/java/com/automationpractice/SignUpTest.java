package com.automationpractice;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.pages.SignUpPage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends WebDriverSettings {

    private static final String SPACE = " ";
    private static final String PREFIX_TO_EMAIL = "dqwfqw";
    private static final String EMAIL = "mypavlo@gmail.com";
    private static final String PARAGRAPH_MESSAGE_ABOUT_EIGHT_ERRORS = "There are 8 errors";
    private static final String CUSTOMER_FIRSTNAME = "Firstname";
    private static final String CUSTOMER_LASTNAME = "Lastname";
    private static final String CUSTOMER_FULL_NAME = CUSTOMER_FIRSTNAME + SPACE + CUSTOMER_LASTNAME;
    private static final String PASSWORD = "12345";
    private static final String FIRSTNAME_FOR_ADDRESS = CUSTOMER_FIRSTNAME;
    private static final String LASTNAME_FOR_ADDRESS = CUSTOMER_LASTNAME;
    private static final String ADDRESS = "My address";
    private static final String CITY = "City";
    private static final String STATE = "Alabama";
    private static final String POSTCODE = "00000";
    private static final String PHONE_NUMBER = "12345678901";
    private static final String ACCOUNT_LINK = "http://automationpractice.com/index.php?controller=my-account";

    @Test
    public void shouldRegisterUser() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openSignInPage();
        signInPage.fillEmailForPreCreate(EMAIL);
        signInPage.submitPreCreate();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.waitUntilPageIsAvailable();
        signUpPage.fillCustomerFirstname(CUSTOMER_FIRSTNAME);
        signUpPage.fillCustomerLastname(CUSTOMER_LASTNAME);
        signUpPage.fillPassword(PASSWORD);
        signUpPage.fillFirstnameForAddress(FIRSTNAME_FOR_ADDRESS);
        signUpPage.fillLastnameForAddress(LASTNAME_FOR_ADDRESS);
        signUpPage.fillAddress(ADDRESS);
        signUpPage.fillCity(CITY);
        signUpPage.chooseState(STATE);
        signUpPage.fillPostcode(POSTCODE);
        signUpPage.fillPhoneNumber(PHONE_NUMBER);
        signUpPage.submitCreationButton();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitUntilPageIsAvailable();
        String result = homePage.getLinkForAccount(CUSTOMER_FULL_NAME);

        assertEquals(ACCOUNT_LINK, result);
    }

    @Test
    public void shouldReturnEightErrorsWhenSubmitCreationWithEmptyField() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openSignInPage();
        signInPage.fillEmailForPreCreate(PREFIX_TO_EMAIL + EMAIL);
        signInPage.submitPreCreate();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.waitUntilPageIsAvailable();
        signUpPage.submitCreationButton();

        String result = signUpPage.getTextAboutErrors();

        assertEquals(result, PARAGRAPH_MESSAGE_ABOUT_EIGHT_ERRORS);
    }
}
