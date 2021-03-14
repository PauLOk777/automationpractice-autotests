package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Page {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(css = "div.alert-danger > p")
    private WebElement errorsParagraph;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "firstname")
    private WebElement firstnameInput;

    @FindBy(id = "lastname")
    private WebElement lastnameInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "city")
    private WebElement cityInput;

    private By stateSelectSelector = By.id("id_state");

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileInput;

    public void submitCreationButton() {
        submitAccountButton.click();
    }

    public String getTextAboutErrors() {
        return errorsParagraph.getText();
    }

    public void fillCustomerFirstname(String firstname) {
        customerFirstnameInput.sendKeys(firstname);
    }

    public void fillCustomerLastname(String lastname) {
        customerLastnameInput.sendKeys(lastname);
    }

    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void fillFirstnameForAddress(String firstname) {
        firstnameInput.sendKeys(firstname);
    }

    public void fillLastnameForAddress(String lastname) {
        lastnameInput.sendKeys(lastname);
    }

    public void fillAddress(String address) {
        address1Input.sendKeys(address);
    }

    public void fillCity(String city) {
        cityInput.sendKeys(city);
    }

    public void chooseState(String state) {
        new Select(getDriver().findElement(stateSelectSelector)).selectByVisibleText(state);
    }

    public void fillPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }

    public void fillPhoneNumber(String phoneNumber) {
        phoneMobileInput.sendKeys(phoneNumber);
    }

    public void waitUntilPageIsAvailable() {
        getWait().until(ExpectedConditions.elementToBeClickable(submitAccountButton));
    }
}
