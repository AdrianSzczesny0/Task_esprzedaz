package com.sellingo.Pages.SideMenus;
import com.sellingo.Pages.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSideMenu extends Base {
    public By mainContainer = By.id("modal-aside-account-menu");
    public By closePopUpButton = By.cssSelector(".l-modal-aside__close");

    public BaseSideMenu(WebDriver driver) {
        super(driver);
    }

    public void close(){
        click(closePopUpButton);
    }

}
