package org.fundacionjala.pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard page the PivotalTracker.
 */
public class Dashboard extends AbstractBasePage {
    @FindBy(css = ".button.button--action")
    private WebElement createProjectButton;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(css = "li[id=\"notice\"]")
    private WebElement messageDeleteWorkspace;



    /**
     * This method contain a message error.
     *
     * @return a message of workspace when is delete
     */
    public String getMessageDeleteWorkspace() {
        return messageDeleteWorkspace.getText();
    }

    /**
     * This method make a refresh.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

}
