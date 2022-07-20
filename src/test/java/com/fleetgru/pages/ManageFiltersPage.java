package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ManageFiltersPage extends BasePage {

    // to check login correct page(driver->quick launchpad, other->dashboard)
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homepageSubTitle;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(xpath = "//span[contains(text(),'Fleet') and @class = 'title title-level-1']")
    public WebElement fleetTab;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicleModule;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterIcon;

    @FindBy(xpath = "//a[@class= 'add-filter-button']")
    public WebElement manageFiltersButton;

    @FindBy(id = "ui-multiselect-0-0-option-0")
    public WebElement licensePlateCheckbox;

    @FindBy(xpath = "//select[@data-action = 'add-filter-select']")
    public WebElement filtersDropdown;

    /*public Select getFilter(){
        return new Select(filtersDropdown);
    }*/


    @FindBy(xpath = "//input[@type = 'search']")
    public WebElement filterInputBox;

    public String typedFilter = "";
    public String clickedFilter = "";








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
