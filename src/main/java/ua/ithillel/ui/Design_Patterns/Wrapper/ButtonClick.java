package ua.ithillel.ui.Design_Patterns.Wrapper;

import org.openqa.selenium.WebElement;

public class ButtonClick {
    private WebElement element;

    public ButtonClick(WebElement element){
        this.element = element;
    }
    public String getValue(){
        return element.getAttribute("value");
    }
    public void setClick(){
        element.click();

    }
}
