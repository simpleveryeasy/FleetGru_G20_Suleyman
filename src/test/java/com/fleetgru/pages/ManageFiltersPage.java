package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ManageFiltersPage extends BasePage {

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterIcon;

    @FindBy(xpath = "//a[@class= 'add-filter-button']")
    public WebElement manageFiltersButton;

    @FindBy(id = "ui-multiselect-0-0-option-0")
    public WebElement licensePlateCheckbox;

    public void navigateToFleetVehicleModule() {

        try {
            BrowserUtils.waitForClickablility(fleetTab, 5);
            new Actions(Driver.getDriver()).moveToElement(fleetTab).pause(200).doubleClick(fleetTab).build().perform();
        } catch (Exception e) {
            System.out.println("fleetTab not clickable");
        }

        try {
            BrowserUtils.waitForVisibility(vehicleModule, 5);
            BrowserUtils.scrollToElementAndClick(vehicleModule);

        } catch (Exception e) {
            System.out.println("vehicleModule not clickable");
        }
    }

}
