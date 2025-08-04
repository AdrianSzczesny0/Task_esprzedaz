package com.sellingo.Pages.Base;
import com.sellingo.Interfaces.VerifablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base implements VerifablePage {
    public String Title = "";
    public By mainContainer = By.cssSelector(".js-main-container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        assertPageTitle(Title,10);
        isVisible(mainContainer);
    }
}
