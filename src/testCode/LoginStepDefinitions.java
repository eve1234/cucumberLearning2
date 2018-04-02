package testCode;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {
	 WebDriver driver = null;
			 //new ChromeDriver();
	//the string values represents what's written in the feature of scenario steps
	//cucumber uses this to associate the test methods with the feature scenario steps
	 //^ : String starts here $ : mean String stops here. Anything else do not belong here 
	 //to the given scenario
	 //(.*com) make it navigate to any URL
	
	 //@Given("^User is on (.*com)$")
	 // | means alternation keyword
	//@Given("^(Navigate to|Open|Launch) http://toolsqa.com$")
	 //?: - is an expression not a variable passing on
	 //(http.*com)- is pass on as a String) to the argument url
	 //Eliminating multiply methods of achieving same thing
	@Given("^User (?:is on|navigates to|launches) (http.*com)$")
	public void navigateTo(String url) throws Throwable {
	 
	 //@Given("^User is on store\\.demoqa\\.com$")
	 //public void user_is_on_store_demoqa_com() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
	   //driver.get("http://store.demoqa.com");
		 //driver.get("http://evevoni.com");
		driver.get(url);
		
	}

	@When("^User clicks on MyAccount Link$")
	public void user_clicks_on_MyAccount_Link() throws Throwable {
	  WebElement myAccountLink = driver.findElement(By.className("account_icon"));
	  myAccountLink.click();
	}
	//create a capture group - (.*) to pass on a variable - (.*)
	//(.*) . - means any character occuring ones numeric or String. * means any number of times of characters
	//for capture groups allows a single method to be use for different scenario steps
	//this method can be use for different username and password
	//. - means representing one character
	@And("^User logs in using valid username (.*) and password (.*)$")
	public void loginDemoQA(String userName, String password) throws Throwable {
		//public void user_logs_in_using_valid_username_and_password(String userName, String password) throws Throwable {  
	   WebElement loginField = driver.findElement(By.id("log"));
	   //loginField.sendKeys("LearnCucumber");//type is username
	   loginField.sendKeys(userName);//type is username
	   
	    WebElement passwordField  =driver.findElement(By.id("pwd"));
	   //passwordField.sendKeys("TestPassword123@");//pwd
	   passwordField.sendKeys(password);//pwd
	   
	   WebElement loginButton = driver.findElement(By.id("login"));
	   loginButton.click(); //click on login button
	}

	@Then("^User is taken to MyAccount page$")
	public void user_is_taken_to_MyAccount_page() throws Throwable {
	  WebElement logOutButton = null;
		try
		{
			logOutButton= driver.findElement(By.id("account_logout"));
		}
		catch(Exception exp)
		{
			//System.out.println("Login is unseccessfull. Not able to find element");
			//throw exp;// throw exp back to Cucumber to inform it that the test has failed
			
		}
		Assert.assertNotNull("Logout button is not there. Therefore, login unsuccessfull.", logOutButton);
	}

}
