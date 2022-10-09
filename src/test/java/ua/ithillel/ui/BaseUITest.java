package ua.ithillel.ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.Design_Patterns.Wrapper.ButtonClick;
import ua.ithillel.ui.Design_Patterns.Wrapper.TextField;
import ua.ithillel.ui.utils.ConfigProvider;

public class BaseUITest extends BaseTest {

    @Test
    public void test() {
        getWebDriver().navigate().to(ConfigProvider.BASE_URL);
     //   getWebDriver().findElement(By.name("q")).sendKeys("webdriver");
        TextField textField = new TextField(getWebDriver().findElement(By.name("q")));
        textField.setValue("webdriver");


    //    getWebDriver().findElements(By.name("btnK")).get(0).click();
        ButtonClick buttonClick = new ButtonClick(getWebDriver().findElements(By.name("btnK")).get(0));
        buttonClick.setClick();
        Assert.assertTrue(getWebDriver().getTitle().contains("webdriver"));
    }

}
