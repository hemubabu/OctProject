Feature: Sauce Login Functionality


Scenario: Valid login

Given User launches the application
When User enters valid credentials
And User clicks the login button
Then User should be logged in successfully

Scenario: Invalid login

Given User launches the application
When User enters Invalid credentials
And User clicks the login button
Then User should be to see the error message


Scenario Outline:: Valid login with data

Given User launches the application
When User enters valid username "<username>"
And User enters valid password "<password>"
And User clicks the login button

Examples:
|username	  | password      |
|standard_user| secret_sauce  |   #1
|wrong_input  | wrong password|   #2 