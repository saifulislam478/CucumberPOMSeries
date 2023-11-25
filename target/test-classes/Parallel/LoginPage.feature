Feature: Login page feature


Scenario: Login page title
Given User is on login page
When User gets the title of the page
Then Page title should be "Test Login | Practice Test Automation"

Scenario: Forget password link
Given User is on login page forget passowrd
Then Forget passowrd link should be displayed

Scenario: Login with correct credential
Given User is on login page
When User enter username "student"
And user enter password "Password123"
And user click on login button
Then User gets the title of the page
And Page title should be "Logged In Successfully | Practice Test Automation"
