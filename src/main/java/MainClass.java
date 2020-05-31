import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/nikita/IdeaProjects/testselenium/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        MainPage mainPage = new MainPage(driver);

       mainPage.register("asdasd", "eferferf@mail.ru", "asd111wdwd");
    }
}
