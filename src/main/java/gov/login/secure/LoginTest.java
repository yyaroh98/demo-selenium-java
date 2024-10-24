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
}
