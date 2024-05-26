
Feature: Customer
Background: Steps for Common for all Scenarios
    Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And  user enter Email as "admin@yourstore.com" and Password as "admin"
    And  Click on Login
    Then  User can view Dashboard  
  
 @sanity @regression   # in this you can run both when ever u can regression or sanity
  Scenario: Add new Customer
  
    
    When User click on the customer Menu
    And Click on customers Menu Item
    And Click on Add new button
    Then User can view Add new Customer page
    When user enter customer info
    And Click on save button
    Then User can view Confirmation message "The new customer has been added successfully."
    And close browser 
  
@regression
Scenario: Search Customer by Email
  
   
    When User click on the customer Menu
    And  Click on customers Menu Item
    And  Enter Customer Email
    When Click on Search button
    Then User Should Found Email in the Search table
    And  close browser


 @regression 
Scenario: Search Customer by Name
 
    When User click on the customer Menu
    And  Click on customers Menu Item
    And  Enter Customer FirstName
    And  Enter Customer LastName
    When Click on Search button
    Then User Should Found Name in the Search table
    And  close browser
    
    
    
    