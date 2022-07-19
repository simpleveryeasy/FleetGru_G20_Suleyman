package com.fleetgru.step_definitions;

import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FilterMenuStepDef {

    VehiclesPage vehiclesPage = new VehiclesPage();


    @When("the user navigates to {string} , {string}")
    public void the_user_navigates_to(String string, String string2) {
        vehiclesPage.navigateToModule(string, string2);
        BrowserUtils.sleep(5);

    }

    @When("the user clicks filter icon")
    public void the_user_clicks_filter_icon() {
       BrowserUtils.clickWithWait(By.xpath("//i[@class='fa-filter hide-text']"),5);
       BrowserUtils.sleep(5);
    }
    @Then("the manage filters button becomes visible")
    public void the_manage_filters_button_becomes_visible() {
            //vehiclesPage.filterIcon.click();
            Assert.assertTrue(vehiclesPage.manageFiltersButton.isDisplayed());

    }





}
