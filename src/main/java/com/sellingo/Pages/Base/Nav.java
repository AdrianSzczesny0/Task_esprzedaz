package com.sellingo.Pages.Base;

import com.sellingo.Enums.NavItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Nav extends Base {
    public By search = By.id("header-search");
    public By account = By.id("header-account");
    public By wishlist = By.id("header-wishlist");
    public By cart = By.id("header-cart");

    public void openSidebar(NavItem navItem){
        switch (navItem){
            case CART:
                click(cart);
                break;
            case MENU:
                // haven't implemented yet
                break;
            case SEARCH:
                click(search);
                break;
            case ACCOUNT:
                click(account);
                break;
            case WISHLIST:
                click(wishlist);
                break;
        }
    }

    public Nav(WebDriver driver) {
        super(driver);
    }
}
