package com.sellingo.Pages;
import com.sellingo.Interfaces.VerifablePage;
import com.sellingo.Models.User;
import com.sellingo.Pages.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base implements VerifablePage {
    public String Title = "Rejestracja";
    public By mainContainer = By.cssSelector(".js-main-container");
    public By emailInput = By.name("email");
    public By passwordInput = By.name("password");
    public By passwordConfirmInput = By.name("password_confirm");
    public By tosCheckbox = By.cssSelector(".c-checkbox-field__checkbox-container");
    public By submitButton = By.cssSelector("button.js-submit-registry");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verify() {
        assertPageTitle(Title,10);
        isVisible(mainContainer);
        isVisible(emailInput);
        isVisible(passwordInput);
        isVisible(passwordConfirmInput);
        isVisible(tosCheckbox);
        isVisible(submitButton);
    }

    public void register(User userData){
        type(emailInput, userData.email);
        type(passwordInput, userData.password);
        type(passwordConfirmInput, userData.rePassword);
        click(tosCheckbox);
        click(submitButton,10);
    }

}
