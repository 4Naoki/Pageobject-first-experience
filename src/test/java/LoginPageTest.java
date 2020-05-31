import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nikita/IdeaProjects/testselenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCreds() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithInvalidCreds() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("d2d23d", "orfkoperfkp");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccLink() {
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
