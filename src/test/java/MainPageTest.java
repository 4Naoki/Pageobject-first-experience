import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nikita/IdeaProjects/testselenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignInButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerWithIncorrectCreds() {
        mainPage.register("qwerty", "asw22sd", "89sd9f2");
        String emailError = mainPage.getEmailErrorText();
        String usernameError = mainPage.getUsernameErrorText();
        String username = mainPage.getInsertedUsername();
        Assert.assertEquals("Email is invalid or already taken", emailError);
        Assert.assertEquals(String.format("Username %s is not available.", username), usernameError);
    }

    @Test
    public void registerWithBlankUsername() {
        SignUpPage signUpPage = mainPage.register("", "asw22sd", "89sd9f2asdasd33d34");
        String blankLoginError = signUpPage.getBlankUserNameErrorText();
        String mainError = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", mainError);
        Assert.assertEquals("Username can't be blank", blankLoginError);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
