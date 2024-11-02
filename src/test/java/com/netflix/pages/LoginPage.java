package com.netflix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        WebElement SignInButtonWebElement = driver.findElement(By.xpath(LoginXpath.SIGN_IN_BUTTON));
        SignInButtonWebElement.click();
    }

    public void inputEmailAddress(String login) {
        WebElement inputEmailAddressWebElement = driver.findElement(By.xpath(LoginXpath.INPUT_LOGIN));
        inputEmailAddressWebElement.sendKeys(login);
    }

    public void inputPassword(String password) {
        WebElement inputEmailAddressWebElement = driver.findElement(By.xpath(LoginXpath.INPUT_PASSWORD));
        inputEmailAddressWebElement.sendKeys(password);
    }


    public String getErrorMessagePasswordField() {
        WebElement textMessage = driver.findElement(By.xpath(LoginXpath.PASSWORD_FIELD_ERROR_MESSAGE));
        return textMessage.getText();
    }

    public String getErrorMessageEmailField() {
        WebElement textMessage = driver.findElement(By.xpath(LoginXpath.EMAIL_FIELD_ERROR_MESSAGE));
        return textMessage.getText();
    }

    public String getErrorMessageWrongCredentials() {
        WebElement textMessage = driver.findElement(By.xpath(LoginXpath.WRONG_CREDENTIALS_ERROR_MESSAGE));
        return textMessage.getText();
    }
}
