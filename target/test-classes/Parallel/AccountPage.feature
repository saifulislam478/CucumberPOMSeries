Feature: Account Page Feature

Background: 
Given User already logged in the application
|username|password|
|student|Password123|

Scenario: Account page Title
Given user in account page
When User gets the title of the page
Then Page title should be "Logged In Successfully | Practice Test Automation"

Scenario: Account Section count
Given user in account page
Then user get account sections
|HOME|
|PRACTICE|
|COURSES|
|BLOG|
|CONTACT|
And Account section count should be 5