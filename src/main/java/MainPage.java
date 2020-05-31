import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@href='/login']");
    private By signUpButton = By.xpath("//a[@href='/login']/following-sibling::a");
    private By usernameField = By.xpath("//*[@id=\"user[login]\"]");
    private By emailField = By.xpath("//*[@id=\"user[email]\"]");
    private By passwordField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpFormButton = By.xpath("//div[@class='mx-auto col-sm-8 col-md-6 hide-sm js-experiment-variant']//form//button[text()='Sign up for GitHub']");
    private By emailError = By.xpath("//dl[@class='form-group errored']//dd[2]");
    private By usernameError = By.xpath("//div[contains(text(), \"Username\") and contains(text(), \"is not available.\")]");

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(usernameError).getText();
    }

    public String getInsertedUsername() {
        String username = driver.findElement(usernameField).getAttribute("value");
        return username;
    }


}
