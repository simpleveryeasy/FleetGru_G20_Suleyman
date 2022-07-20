package com.fleetgru.step_definitions;

import com.fleetgru.pages.ManageFiltersPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FilterMenuStepDef {

    VehiclesPage vehiclesPage = new VehiclesPage();
    ManageFiltersPage manageFiltersPage = new ManageFiltersPage();


    @When("the user navigates to Fleet Vehicles module")
    public void the_user_navigates_to_fleet_vehicles_module() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(5);
        manageFiltersPage.navigateToFleetVehicleModule();
        BrowserUtils.sleep(5);

    }

    @When("the user clicks filter icon")
    public void the_user_clicks_filter_icon() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithWait(By.xpath("//i[@class='fa-filter hide-text']"), 5);
        BrowserUtils.sleep(5);
    }

    @Then("the manage filters button becomes visible")
    public void the_manage_filters_button_becomes_visible() {
        Assert.assertTrue(manageFiltersPage.manageFiltersButton.isDisplayed());
    }

    @When("the user clicks the manage filters button")
    public void the_user_clicks_the_manage_filters_button() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();

        if (manageFiltersPage.manageFiltersButton.isDisplayed()) {
            manageFiltersPage.manageFiltersButton.click();
            BrowserUtils.sleep(5);
        } else {
            BrowserUtils.waitForClickablility(manageFiltersPage.filterIcon, 10);
            BrowserUtils.sleep(5);
            manageFiltersPage.manageFiltersButton.click();
            BrowserUtils.sleep(5);
        }

    }

    @Then("filter names become clickable")
    public void filter_names_become_clickable() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(5);
        Select select = new Select(manageFiltersPage.filtersDropdown);
        System.out.println("select.isMultiple() = " + select.isMultiple());
        Assert.assertTrue(select.isMultiple());

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].setAttribute('style','visibility:visible;');",select);
        select.selectByVisibleText("Tags");



        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @When("the user waits because it's driver")
    public void the_user_waits_because_it_s_driver() {
        BrowserUtils.sleep(10);
    }

    @When("the user scroll to filter icon and clicks")
    public void the_user_scroll_to_filter_icon_and_clicks() {
        BrowserUtils.scrollToElementAndClick(manageFiltersPage.filterIcon);
    }


    @When("the user types {string} into input box")
    public void theUserTypesIntoInputBox(String arg0) {
        manageFiltersPage.filterInputBox.sendKeys(arg0, Keys.ENTER);
        manageFiltersPage.typedFilter = arg0;
        BrowserUtils.sleep(3);


    }




    @Then("typed filter name becomes clickable")
    public void typed_filter_name_becomes_clickable() {
        System.out.println("manageFiltersPage.typedFilter = " + manageFiltersPage.typedFilter);

        BrowserUtils.sleep(3);



    }



}
