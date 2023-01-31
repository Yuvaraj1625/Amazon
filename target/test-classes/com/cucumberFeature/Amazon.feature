
Feature: It is An ecommerence Application Allows The User To Purchase Product

@smoke
Scenario Outline: Home Page

Given userLaunch the Application Url
When user Selectes the "dropDown" From
And  user Search The "product" In SearchBox
Then user Click The Searched Product From The Suggestion and It navigates To productPage

Examples:
|dropDown|product|
|Baby|soft toys|


Scenario: Product Page 