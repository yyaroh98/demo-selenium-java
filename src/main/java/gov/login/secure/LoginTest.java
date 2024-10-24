package gov.login.secure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String buttonSingInXpath = "//*[@id=\"main-content\"]/div/nav/ul/li[1]/a";
        By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(buttonSingInBy);
        buttonSingInWebElement.click();
    }

    @Test
    public void test2() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String inputEmailXpath = "//*[@id=\"user_email\"]";
        By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = webDriver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testA@test.com");

        String buttonSingInXpath = "//*[@id=\"new_user\"]/lg-submit-button/button";
        By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(buttonSingInBy);
        buttonSingInWebElement.click();
    }

    @Test
    public void test3() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String inputPasswordXpath = "/html/body/main/div/form/lg-password-toggle/lg-validated-field/div/input";
        By inputPasswordBy = By.xpath(inputPasswordXpath);
        WebElement inputPasswordWebElement = webDriver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("1q2w#E4r"); //крашится тест?

        String buttonSingInXpath = "//*[@id=\"new_user\"]/lg-submit-button/button";
        By buttonSingInBy = By.xpath(buttonSingInXpath);
        WebElement buttonSingInWebElement = webDriver.findElement(buttonSingInBy);
        buttonSingInWebElement.click();
    }
}


