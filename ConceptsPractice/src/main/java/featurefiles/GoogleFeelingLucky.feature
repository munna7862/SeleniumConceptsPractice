Feature: Google Feeling Lucky

#Without Example Keyword
#Scenario: Google Feeling Lucky Page
#
#Given User is on google page
#When User enters "Jaffar Sadhik"
#And User clicks the search button
#Then User able to search the data


#With Example Keyword
@GFeeling @Google
Scenario Outline: Google Feeling Lucky Page

Given User is on google page
When User enters "<text>"
And User clicks the I'm Feeling Lucky button


Examples:
	|text|
	|Jaffar Sadhik|
	|Sadhik|