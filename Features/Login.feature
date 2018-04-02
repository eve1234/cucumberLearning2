Feature: Login Test
  
  This feature file contains all the login test
  
  #Cucumber will first check the back ground when running
  #Used to eliminate duplicate steps
	Background:
		Given User is on http://store.demoqa.com
    When User clicks on MyAccount Link
	
  Scenario: Verify that user is able to login using valid username and password
    And User logs in using valid username LearnCucumber and password TestPassword123@ 
    Then User is taken to MyAccount page
    
 Scenario: Verify that user is able to login using valid username and invalid password
    And User logs in using valid username LearnCucumber and password TestPassword 
    Then User is taken to MyAccount page
    
    
    #Scenario: Verify that user is able to login to 
    #Given User navigates to http://store.demoqa.com
    #http://toolsqa.com
    
    #Scenario: Verify that login is working 
    #Given User launches http://forumqa.com
    
    