package org.fundacionjala.pivotal.ui.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;

/**
 * This class doing the manage the accounts.
 */
public class ManageAccount extends AbstractBasePage {
    @FindBy(css = ".account_name>span")
    private WebElement accountNameLabel;

    /**
     * This method doing click on "Setting" button.
     *
     * @param name String  whit the setting name.
     * @return SettingAccount page.
     */
    public SettingAccount clickSetting(final String name) {
        WebElement settingButton = driver.findElement(By.cssSelector("a[href='" + name + "']"));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

    /**
     * This method wait while loading element.
     */
    public void waitPage() {
        wait.until(ExpectedConditions.visibilityOf(accountNameLabel));
    }

    /**
     * This method will get the account name in manage account.
     *
     * @return account name.
     */
    public String getAccountName() {
        return CommonActions.getText(accountNameLabel);
    }
}
