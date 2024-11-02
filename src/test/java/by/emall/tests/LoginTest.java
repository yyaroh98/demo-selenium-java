package by.emall.tests;

import by.emall.pages.LoginMessage;
import by.emall.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    private static final String LOGIN = "297560602";
    private static final String PASSWORD = "7560602";
    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://emall.by/login/password");
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Тест: не указан логин и пароль")
    public void testSignInWithEmptyLoginAndPassword() {
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_LOGIN_AND_PASSWORD, loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Тест: не указан пароль")
    public void testSignInWithEmptyPassword() {
        loginPage.inputEmailAddress(LOGIN);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_PASSWORD, loginPage.getErrorMessage());

        //    Assertions.assertEquals(LoginMessage.EMPTY_FIELD_PASSWORD, loginPage.getErrorMessagePassworEmpty());
    }

    @Test
    @DisplayName("Тест: не указан логин")
    public void testSignInWithEmptyLogin() {
        loginPage.inputPassword(PASSWORD);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.EMPTY_FIELD_LOGIN, loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Тест: неверные учетные данные")
    public void testSignInWithEmailAndPassword() {
        loginPage.inputEmailAddress(LOGIN);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickSignInButton();

        Assertions.assertEquals(LoginMessage.WRONG_CREDENTIALS, loginPage.getErrorMessage());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
