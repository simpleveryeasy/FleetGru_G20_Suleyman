package com.fleetgru.step_definitions;

import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        //WebDriver driver = Driver.get();
        Driver.getDriver().get(url);
    }

    @When("the user enters the driver information")
        public void the_user_enters_the_driver_information() throws InterruptedException {
            String username = ConfigurationReader.getProperty("driver_username");
            String password = ConfigurationReader.getProperty("driver_password");

            //LoginPage loginPage = new LoginPage();
            loginPage.login(username,password);
            loginPage.userType = "driver";
        }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.sleep(5);
        String actualTitle = loginPage.homepageSubTitle.getText();
        String expectedTitle = "";
        switch (loginPage.userType){
            case "driver":
                expectedTitle = ConfigurationReader.getProperty("driver_expectedTitle");
                break;
            case "salesManager":
                expectedTitle = ConfigurationReader.getProperty("sales_manager_expectedTitle");
                break;
            case "storeManager":
                expectedTitle = ConfigurationReader.getProperty("store_manager_expectedTitle");
                break;
        }

        System.out.println('\"'+ actualTitle + '\"');
        System.out.println(expectedTitle);

        Assert.assertEquals(expectedTitle,'\"'+ actualTitle + '\"');

    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() throws InterruptedException {
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");

        //LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        loginPage.userType = "salesManager";

    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");

        //LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        loginPage.userType = "storeManager";
    }


}
