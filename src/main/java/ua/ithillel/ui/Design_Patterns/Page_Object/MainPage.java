package ua.ithillel.ui.Design_Patterns.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.ithillel.ui.Design_Patterns.User;
import ua.ithillel.ui.utils.ConfigProvider;
import ua.ithillel.ui.utils.WaitUtils;

public class MainPage extends Page {


    private By registerLink = By.xpath("//a[@data-target='#register-modal']");
    private By logoutLink = By.linkText("Logout");

    public static final String Title = "WeaveSocks";

    public MainPage(WebDriver driver){
        super(driver);
    }
     public boolean isUserLoggedIn(){
      return   driver.findElements(logoutLink).size()> 0;
     }
    public void isUserSuccessfullyLogin(){
        Assert.assertEquals(driver.findElement(By.id("login-message")).getText(), "Login successful.");
    }
    @Override
    public void open(){
        driver.get(ConfigProvider.BASE_URL);
        ensureOpen();
    }

    public void ensureOpen() {
        WaitUtils.waitUtilElementIsVisible(driver,registerLink);
    }

    public String getTitle(){
        return Title;
    }
    public LoginForm clickLogin(){

        return new LoginForm();
    }

    public LoginForm logout() {
        WaitUtils.waitUtilElementIsVisible(driver, logoutLink);
        driver.findElement(logoutLink).click();
        return new LoginForm();

    }
    public RegisterForm clickRegister(){
        driver.findElement(registerLink).click();
       return new RegisterForm();

    }
    public class  RegisterForm {
        private By userName = By.id("register-username-modal");
        private By firstName = By.id("register-first-modal");
        private By lastName = By.id("register-last-modal");
        private By email = By.id("register-email-modal");
        private By password = By.id("register-password-modal");
        private By registerButton = By.xpath("//button[normalize-space()='Register']");


        public void fillResisterForm(User user) {
            // TextField userName = new TextField(driver.findElement(userName));
            driver.findElement(userName).sendKeys(user.getUserName());
            driver.findElement(firstName).sendKeys(user.getFirstName());
            driver.findElement(lastName).sendKeys(user.getLastName());
            driver.findElement(email).sendKeys(user.getEmail());
            driver.findElement(password).sendKeys(user.getPassword());
            driver.findElement(registerButton).click();


        }
    }
    public class  LoginForm {
        private By userloginName = By.id("username-modal");
        private By passwordlogin = By.id("password-modal");
        private By loginButton = By.xpath("//button[contains(.,\' Log in\')]");
        private By login = By.xpath("//a[@data-target='#login-modal']");

        public void fillLoginForm(User user) {

            WaitUtils.waitUtilElementIsVisible(driver,login);
            driver.findElement(login).click();
            driver.findElement(userloginName).sendKeys(user.getUserName());
            driver.findElement(passwordlogin).sendKeys(user.getPassword());
            driver.findElement(loginButton).click();

        }


    }
}
