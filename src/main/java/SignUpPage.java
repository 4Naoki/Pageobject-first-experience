import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//h1[text()='Create your account']");
    private By userNameField = By.xpath("//*[@id=\"user_login\"]");
    private By emailField = By.xpath("//*[@id=\"user_email\"]");
    private By passwordField = By.xpath("//*[@id=\"user_password\"]");
    private By mainError = By.xpath("//div[contains(text(), 'There were problems creating your account.')]");
    private By blankLoginError = By.xpath("//dl[@class='form-group my-3 errored required']//dd[@class='error' and not(contains(text(), \"Email is invalid or already taken\"))]");
    private By strongPassword = By.xpath("//*[@id=\"signup-form\"]/password-strength/p/span[1]");
    private By minCharsInPassword = By.xpath("//*[@id=\"signup-form\"]/password-strength/p/span[2]");
    private By minNumbersInPassword = By.xpath("//*[@id=\"signup-form\"]/password-strength/p/span[3]");
    private By lowercaseLetterInPassword = By.xpath("//*[@id=\"signup-form\"]/password-strength/p/span[4]");


    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        return new SignUpPage(driver);
    }

    public String passwordHasMinChars(){
        String state = driver.findElement(minCharsInPassword).getAttribute("class");
        return state;
    }

    public String passwordHasMinNumbers(){
        String state = driver.findElement(minNumbersInPassword).getAttribute("class");
        return state;
    }

    public String passwordHasLovercaseChar(){
        String state = driver.findElement(lowercaseLetterInPassword).getAttribute("class");
        return state;
    }

    public String passwordIsStrong(){
        String state = driver.findElement(strongPassword).getAttribute("class");
        return state;
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }

    public String getBlankUserNameErrorText() {
        return driver.findElement(blankLoginError).getText();
    }


}
