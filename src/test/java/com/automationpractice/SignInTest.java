package com.automationpractice;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignInPage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SignInTest extends WebDriverSettings {

    private static final String USER_FULL_NAME = "Paul Lenser";
    private static final String USER_EMAIL = "trocjuk2000@gmail.com";
    private static final String USER_PASSWORD = "12345678";
    private static final String WRONG_USER_EMAIL = "aboba@gmail.com";
    private static final String WRONG_USER_PASSWORD = "12678";
    private static final String INVALID_EMAIL = "invalid_email";
    private static final String AUTHENTICATION_FAILED_MESSAGE = "Authentication failed.";
    private static final String INVALID_EMAIL_ADDRESS_MESSAGE = "Invalid email address.";
    private static final String ACCOUNT_LINK = "http://automationpractice.com/index.php?controller=my-account";

    @Test
    public void shouldSignIn() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openSignInPage();
        signInPage.fillEmailForSignIn(USER_EMAIL);
        signInPage.fillPasswordForSignIn(USER_PASSWORD);
        signInPage.submitSignIn();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.waitUntilPageIsAvailable();
        String result = homePage.getLinkForAccount(USER_FULL_NAME);

        assertEquals(ACCOUNT_LINK, result);
    }

    @Test
    public void shouldShowErrorAuthenticationFailedWhenWrongCredentialsForSignIn() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openSignInPage();
        signInPage.fillEmailForSignIn(WRONG_USER_EMAIL);
        signInPage.fillPasswordForSignIn(WRONG_USER_PASSWORD);
        signInPage.submitSignIn();

        String result = signInPage.getAuthenticationFailedMessage();

        assertEquals(result, AUTHENTICATION_FAILED_MESSAGE);
    }

    @Test
    public void shouldShowErrorInvalidEmailAddressWhenWrongEmailForPreCreate() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openSignInPage();
        signInPage.fillEmailForPreCreate(INVALID_EMAIL);
        signInPage.submitPreCreate();

        String result = signInPage.getInvalidEmailAddressPreCreateMessage();

        assertEquals(result, INVALID_EMAIL_ADDRESS_MESSAGE);
    }
}
