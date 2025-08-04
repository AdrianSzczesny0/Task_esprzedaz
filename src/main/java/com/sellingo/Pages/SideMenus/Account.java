package com.sellingo.Pages.SideMenus;

import com.sellingo.Interfaces.VerifablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Account extends BaseSideMenu implements VerifablePage {
    public By myAccount = By.xpath("//a[contains(.,'Moje dane')]");
    public By transactionHistory = By.xpath("//a[contains(.,'Historia zamówień')]");
    public By logout = By.xpath("//a[contains(.,'Wyloguj się')]");

    public Account(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        isVisible(mainContainer);
        isVisible(myAccount);
        isVisible(transactionHistory);
        isVisible(logout);
        isVisible(closePopUpButton);
    }
    public void logout(){
        click(logout);
    }
    public void openMyAccountPage(){
        WebElement accountSidebar = driver.findElement(mainContainer);
        accountSidebar.findElement(By.xpath(".//a[contains(., 'Moje dane')]")).click();
        click(myAccount);
    }
}