package com.fleetgru.step_definitions;

import com.fleetgru.pages.ManageFiltersPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FilterMenuStepDef {

    VehiclesPage vehiclesPage = new VehiclesPage();
    ManageFiltersPage manageFiltersPage = new ManageFiltersPage();


    @When("the user navigates to Fleet Vehicles module")
    public void the_user_navigates_to_fleet_vehicles_module() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();
        manageFiltersPage.navigateToFleetVehicleModule();
        BrowserUtils.sleep(5);

    }

    @When("the user clicks filter icon")
    public void the_user_clicks_filter_icon() {
        manageFiltersPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithWait(By.xpath("//i[@class='fa-filter hide-text']"),5);
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
        }else{
            BrowserUtils.waitForClickablility(manageFiltersPage.filterIcon,10);
            BrowserUtils.sleep(5);
            manageFiltersPage.manageFiltersButton.click();
            BrowserUtils.sleep(5);
        }

    }
    @Then("filter names become clickable")
    public void filter_names_become_clickable() {
        Assert.assertTrue(manageFiltersPage.licensePlateCheckbox.isDisplayed());
    }



}
