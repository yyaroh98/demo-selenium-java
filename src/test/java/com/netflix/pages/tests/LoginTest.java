package com.netflix.pages.tests;

import com.netflix.pages.LoginMessage;
import com.netflix.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    private static final String EMAIL = "test1@test.com";
    private static final String PASSWORD = "7788#_@";
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.netflix.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Тест: не указан логин и пароль")
    public void testSignInWithEmptyLoginAndPassword() {
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_LOGIN, loginPage.getErrorMessageEmailField());
        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_PASSWORD, loginPage.getErrorMessagePasswordField());
    }

    @Test
    @DisplayName("Тест: не указан пароль")
    public void testSignInWithEmptyPassword() {
        loginPage.inputEmailAddress(EMAIL);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_PASSWORD, loginPage.getErrorMessagePasswordField());
    }

    @Test
    @DisplayName("Тест: не указан логин")
    public void testSignInWithEmptyEmail() {
        loginPage.inputPassword(PASSWORD);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_LOGIN, loginPage.getErrorMessageEmailField());
    }

    @Test
    @DisplayName("Тест: неверные учетные данные")
    public void testSignInWithEmailAndPassword() {
        loginPage.inputEmailAddress(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.WRONG_CREDENTIALS + EMAIL, loginPage.getErrorMessageWrongCredentials());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
