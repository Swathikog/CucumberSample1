Feature: Login

Scenario Outline: Successful Login 	

Given Launch the browser
When Open url
Then Login with valid credentials "<email>" "<password>"
Then Login with Invalid credentials 
And close browser

Examples:

|  email  |  password  |
|  admin  |  Admin123  |
|  admin  |  adbjqwdg  |


