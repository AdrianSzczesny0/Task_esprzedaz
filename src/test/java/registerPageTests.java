import com.sellingo.Models.User;
import com.sellingo.Utility.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sellingo.Enums.NavItem.ACCOUNT;
import static com.sellingo.Enums.Page.*;

public class registerPageTests extends BaseTest {

    // i have created the test in 2 approaches
    // first the more generic one where we create less methods and use generic ones like :
    // type, click etc

    @Test
    public void registerTest() {
        goTo(REGISTER_PAGE);
        User testUser = new User();
        verifyPageLoaded(REGISTER_PAGE);
        type(registerPage.emailInput, testUser.email);
        type(registerPage.passwordInput, testUser.password);
        type(registerPage.passwordConfirmInput, testUser.rePassword);
        click(registerPage.tosCheckbox);
        click(registerPage.submitButton,10);
        verifyPageLoaded(POP_UP);
        click(popUp.closeButton);
        click(nav.account);
        account.verify();
        account.openMyAccountPage();
        myAccountPage.verify();
        String actualEmailValue = getInputValue(myAccountPage.emailInput);
        Assert.assertEquals(actualEmailValue, testUser.email);
        click(myAccountPage.logoutButton);

    }

    // second using dedicated functions for certain actions.
    // as this approach is good, it can sometimes get really bloated with custom methods
    @Test
    public void registerTestShortened() throws InterruptedException {
        User testUser = new User();
        registerPage.verify();
        registerPage.register(testUser);
        popUp.verify();
        popUp.close();
        nav.openSidebar(ACCOUNT);
        account.verify();
        account.openMyAccountPage();
        myAccountPage.verify();
        String actualEmailValue = myAccountPage.getEmailValue();
        Assert.assertEquals(actualEmailValue, testUser.email);
        myAccountPage.logout();
    }

}
