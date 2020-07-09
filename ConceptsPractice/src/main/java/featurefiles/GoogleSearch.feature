Feature: Google Search 

#Without Example Keyword
#Scenario: Google Page
#
#Given User is on google page
#When User enters "Jaffar Sadhik"
#And User clicks the search button
#Then User able to search the data


#With Example Keyword
@Gsearch @Google 
Scenario: Google Search Page 

	Given User is on google page 
	When User enters text 
		|Jaffar Sadhik|
	And User clicks the search button 
	Then User able to search the text 
		|Jaffar Sadhik|
		
