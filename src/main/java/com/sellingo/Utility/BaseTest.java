package com.sellingo.Utility;
import com.sellingo.Enums.Page;
import com.sellingo.Pages.Base.Base;
import com.sellingo.Pages.Base.HomePage;
import com.sellingo.Pages.Base.Nav;
import com.sellingo.Pages.LoginPage;
import com.sellingo.Pages.MyAccountPage;
import com.sellingo.Pages.PopUp;
import com.sellingo.Pages.RegisterPage;
import com.sellingo.Pages.SideMenus.Account;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static com.sellingo.Enums.NavItem.ACCOUNT;

public class BaseTest extends Base {
    protected WebDriver driver;
    protected static ConfigLoader config;
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected PopUp popUp;
    protected Nav nav;
    protected Account account;
    protected MyAccountPage myAccountPage;

    public BaseTest() {
        super(null);
    }

    @BeforeMethod
    protected void setUp(Method method) {
        initializeDriver();
        initializePages();
        driver.get(config.getProperty("baseUrl") + config.getProperty("register"));
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void goTo(Page page){
        switch (page){
            case HOME_PAGE:
                driver.get(config.getProperty("baseUrl") + config.getProperty("home"));
                break;
            case LOGIN_PAGE:
                driver.get(config.getProperty("baseUrl") + config.getProperty("login"));
                break;
            case REGISTER_PAGE:
                driver.get(config.getProperty("baseUrl") + config.getProperty("register"));
                break;
        }
    }

    protected void initializePages(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popUp = new PopUp(driver);
        nav = new Nav(driver);
        account = new Account(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    protected void initializeDriver(){
        config = new ConfigLoader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        super.setDriver(driver);
    }

    protected void verifyPageLoaded(Page page){
        switch (page){
            case HOME_PAGE:
                homePage.verify();
                break;
            case LOGIN_PAGE:
                loginPage.verify();
                break;
            case REGISTER_PAGE:
                registerPage.verify();
                break;
            case POP_UP:
                popUp.verify();
                break;
        }
    }
    protected void logout(){
        nav.openSidebar(ACCOUNT);
        account.verify();
        account.logout();
    }

}