package com.sellingo.Pages;

import com.sellingo.Interfaces.VerifablePage;
import com.sellingo.Pages.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PopUp extends Base implements VerifablePage {

    public By main = By.cssSelector(".is-open.is-active");
    public By header = By.cssSelector("");
    public By content = By.cssSelector(".l-popup__message-content");
    public By closeButton = By.cssSelector(".l-popup__message-close");
    public PopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        waitForElementVisible(main,10);
    }

    public String getPopUpMessage(){
        return getText(content,10);
    }
    public void close(){
        click(closeButton);
    }
    public void assertPopUpMessage(String expectedMessage){
        Assert.assertEquals(getText(content), expectedMessage);
    }
}
