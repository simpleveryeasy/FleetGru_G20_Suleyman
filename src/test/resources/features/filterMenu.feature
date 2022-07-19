@wip
Feature: Users should be able to use filter menu

  Background:
    Given the user is on the login page


  Scenario: Use filter menu as a driver
    When the user enters the driver information
    When the user navigates to "Fleet" , "Vehicles"
    When the user clicks filter icon
    Then the manage filters button becomes visible



  Scenario: Use filter menu as a sales manager
    When the user enters the sales manager information
    When the user navigates to "Fleet" , "Vehicles"
    When the user clicks filter icon
    Then the manage filters button becomes visible


  Scenario: Use filter menu as a store manager
    When the user enters the store manager information
    When the user navigates to "Fleet" , "Vehicles"
    When the user clicks filter icon
    Then the manage filters button becomes visible