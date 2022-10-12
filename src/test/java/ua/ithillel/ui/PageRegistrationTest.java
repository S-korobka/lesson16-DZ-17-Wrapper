package ua.ithillel.ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.Design_Patterns.Page_Object.MainPage;
import ua.ithillel.ui.Design_Patterns.User;

public class PageObjectTest extends BaseUITest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();
        Assert.assertEquals(getWebDriver().getTitle(),mainPage.getTitle());
        MainPage.RegisterForm registerForm = mainPage.clickRegister();
        registerForm.fillResisterForm(User.builder().buildRandomUser());
        Assert.assertTrue(mainPage.isUserLoggedIn());
    }



}