package com.sellingo.Pages;

import com.sellingo.Interfaces.VerifablePage;
import com.sellingo.Pages.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Base implements VerifablePage {
    public By emailInput = By.name("email");
    public By myAccountModule = By.cssSelector("[data-catalog='account']");
    public By logoutButton = By.xpath("//a[contains(.,'Wyloguj się')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        isVisible(myAccountModule);
    }

    public String getEmailValue(){
        return getInputValue(emailInput);
    }
    public void logout(){
        click(logoutButton);
    }
}
