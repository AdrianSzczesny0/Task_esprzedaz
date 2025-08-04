package com.sellingo.Pages;
import com.sellingo.Interfaces.VerifablePage;
import com.sellingo.Models.User;
import com.sellingo.Pages.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base implements VerifablePage {
    public String Title = "ZalogujSie";
    public By mainContainer = By.cssSelector(".js-main-container");
    public By emailInput = By.name("email");
    public By passwordInput = By.name("password");
    public By submitButton = By.cssSelector("button.js-submit-registry");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        assertPageTitle(Title,10);
        isVisible(mainContainer);
        isVisible(emailInput);
        isVisible(passwordInput);
        isVisible(submitButton);
    }

    public void login(User userData){
        type(emailInput, userData.email);
        type(passwordInput, userData.password);
        click(submitButton,10);
    }

}
