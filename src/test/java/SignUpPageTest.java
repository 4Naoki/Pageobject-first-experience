import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private  SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nikita/IdeaProjects/testselenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?source=header-home");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void passwordHasIncorrectParameters() {
        signUpPage.typePassword("D");
        String numCondition = signUpPage.passwordHasMinNumbers();
        String charCondition = signUpPage.passwordHasMinChars();
        String lowercaseCondition = signUpPage.passwordHasLovercaseChar();
        String strongPasswordCondition = signUpPage.passwordIsStrong();

        System.out.println(numCondition + charCondition + lowercaseCondition + strongPasswordCondition);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
