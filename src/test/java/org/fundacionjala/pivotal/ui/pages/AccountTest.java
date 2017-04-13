package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.pivotal.ui.pages.account.Account;
import org.fundacionjala.pivotal.ui.pages.account.ManageAccount;
import org.fundacionjala.pivotal.ui.pages.menu.TopMenu;
import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.fundacionjala.pivotal.ui.pages.common.CommonNavigator.goToDashboard;

/**
 * Created by Bruno Barrios on 4/12/2017.
 */
public class AccountTest {
    private Account account;

    /**
     * This before will be executed before a suite.
     */
    @BeforeSuite
    public void beforeSuite() {
         SignInForm.loginAsPrimaryUser();
    }

    /**
     * This test will create account name.
     */
    @Test
    public void createAccount() {
        TopMenu topMenu = new TopMenu();
        topMenu.clickUserNameDropDown();
        account = topMenu.clickAccountDropDownItem();
        final String accountName = "BRUNO REY";
        ManageAccount manageAccount = account.createAccount(accountName);
        manageAccount.waitPage();

        Assert.assertEquals(accountName, manageAccount.getAccountName());

        topMenu.clickUserNameDropDown();
        topMenu.clickAccountDropDownItem();

        Assert.assertTrue(account.isAccountDisplayed(accountName));

    }

    /**
     * This method will clean pivatoal environment.
     */
    @AfterSuite
    public void tearDown() {
        account.deleteAllAccounts(account.getManageAccountButtonList());
        goToDashboard();
    }
}
