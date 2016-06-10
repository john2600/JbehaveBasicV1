Narrative:
In order to give small changes
As a change machine
I want to give the small number of coins for an ammount of money
					 
Scenario: one coin Changes

Given a change machine
When I ask for change of <value>
Then it returns the <coin> coins

Examples:
|value|coin|
|0.01|1c|
|0.02|1c,1c|
|0.03|1c,1c,1c|
|0.04|1c,1c,1c,1c|
|0.05|5c|
|0.06|5c,1c|
|0.07|5c,1c,1c|
|0.20|10c,10c|

Scenario: Only coing Changes

Given a change machine
When I ask for change of 1.00
Then it will raise an error

Given a change machine
When I ask for change of -0.10
Then it will raise an error

