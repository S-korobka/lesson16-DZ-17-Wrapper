package ua.ithillel.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.Design_Patterns.Page_Object.MainPage;
import ua.ithillel.ui.Design_Patterns.User;

public class PageLoginTest extends BaseUITest {


    @Test
    public void test() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegister();
        User user = User.buildRandomUser();
        registerForm.fillResisterForm(user);

        Assert.assertTrue(mainPage.isUserLoggedIn());
        MainPage main = new MainPage(getWebDriver());
        MainPage.LoginForm loginForm = main.logout();

        loginForm.fillLoginForm(user);
        Assert.assertTrue(mainPage.isUserLoggedIn());

    }



}
