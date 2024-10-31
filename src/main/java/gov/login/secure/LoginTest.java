package gov.login.secure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    @DisplayName("Тест: пустой email & password")
    public void testSignInWithEmptyEmailAndPassword() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        //String buttonSingInXpath = "//*[@id=\"main-content\"]/div/nav/ul/li[1]/a";
        //By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(By.name("button"));
        buttonSingInWebElement.click();

        String expectedEmptyFieldErrorMessage = "This field is required";
        String actualEmptyEmailErrorMessage = webDriver.findElement(By.xpath("//div[@class=\'usa-error-message\']")).getText();
        String actualEmptyPasswordErrorMessage = webDriver.findElement(By.xpath("//div[@class=\'usa-error-message\']")).getText();

        Assertions.assertEquals(expectedEmptyFieldErrorMessage, actualEmptyEmailErrorMessage);
        Assertions.assertEquals(expectedEmptyFieldErrorMessage, actualEmptyPasswordErrorMessage);
    }

    @Test
    @DisplayName("Тест: пустой password")
    public void testSignInWithEmptyPassword() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        //String inputEmailXpath = "//*[@id=\"user_email\"]";
        //By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = webDriver.findElement(By.id("user_email"));
        inputEmailWebElement.sendKeys("test@test.com");

        //String buttonSingInXpath = "//button[@name=\"button\"]";
        //By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(By.name("button"));
        buttonSingInWebElement.click();

        String expectedEmptyFieldErrorMessage = "This field is required";
        String actualEmptyPasswordErrorMessage = webDriver.findElement(By.xpath("//div[@class=\'usa-error-message\']")).getText();

        Assertions.assertEquals(expectedEmptyFieldErrorMessage, actualEmptyPasswordErrorMessage);
    }

    @Test
    @DisplayName("Тест: пустой email")
    public void testSignInWithEmptyEmail() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        //String inputPasswordLacator = "//input[@name='user[password]']";
        //By inputPasswordBy = By.xpath(inputPasswordLacator);
        WebElement inputPasswordWebElement = webDriver.findElement(By.xpath("//input[@name=\'user[password]\']"));
        inputPasswordWebElement.sendKeys("7788@#_test");

        // String buttonSingInXpath = "//*[@id=\"new_user\"]/lg-submit-button/button";
        // By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(By.name("button"));
        buttonSingInWebElement.click();

        String expectedEmptyFieldErrorMessage = "This field is required";
        String actualEmptyEmailErrorMessage = webDriver.findElement(By.className("usa-error-message")).getText();

        Assertions.assertEquals(expectedEmptyFieldErrorMessage, actualEmptyEmailErrorMessage);
    }

    @Test
    @DisplayName("Тест: неверные учетные данные")
    public void testSignInWithWrongCredentials() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriver.get("https://secure.login.gov/");

        // String inputEmailXpath = "//*[@id=\"user_email\"]";
        // By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = webDriver.findElement(By.id("user_email"));
        inputEmailWebElement.sendKeys("test@test.com");

        // String inputPasswordXpath = "/html/body/main/div/form/lg-password-toggle/lg-validated-field/div/input";
        // By inputPasswordBy = By.xpath(inputPasswordXpath);
        WebElement inputPasswordWebElement = webDriver.findElement(By.xpath("//input[@name=\'user[password]\']"));
        inputPasswordWebElement.sendKeys("7788@#_test");

        //String buttonSingInXpath = "//*[@id=\"new_user\"]/lg-submit-button/button";
        //By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(By.name("button"));
        buttonSingInWebElement.click();

        String expectedWrongCredentialsErrorMessage = "The email or password you’ve entered is wrong. Try resetting your password.";
        String actualWrongCredentialsErrorMessage = webDriver.findElement(By.xpath("//p[@class=\'usa-alert__text\']")).getText();

        Assertions.assertEquals(expectedWrongCredentialsErrorMessage, actualWrongCredentialsErrorMessage);
    }
}


