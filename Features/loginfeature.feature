
Feature: Login
@sanity
  Scenario: Successful Login with Valid Credentials
    Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And  user enter Email as "admin@yourstore.com" and Password as "admin"
    And  Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Log out link
    Then Page Title should be as "Your store. Login" 
    And close browser
    
 @sanity
    Scenario Outline: Successful Login with Valid Credential DDT
   Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And  user enter Email as "<email>" and Password as "<password>"
    And  Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Log out link
    Then Page Title should be "Your store. Login" 
    And close browser
    

Examples:
| email | password |
| admin@yourstore.com | admin |
| test1@yourstore.com | admin |


 