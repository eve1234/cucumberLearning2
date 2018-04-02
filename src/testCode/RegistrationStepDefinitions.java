package testCode;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;


public class RegistrationStepDefinitions {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("^User goes to http://demoqa\\.com/registration/$")
	public void goToRegistrationPage() throws Throwable {
	    driver.get("http://demoqa.com/registration/");
	    
	}

	@When("^User fills in the given details registration form$")
	public void fillTheForm(DataTable testData) throws Throwable {
		//List<String> testDataAslist = testData.asList(String.class);
		
		//*driver.findElement(By.id("name_3_firstname")).sendKeys(testDataAslist.get(0));
		//driver.findElement(By.id("name_3_lastname")).sendKeys(testDataAslist.get(1));
		//driver.findElement(By.id("phone_9")).sendKeys(testDataAslist.get(2));
		//driver.findElement(By.id("username")).sendKeys(testDataAslist.get(3));
		
		Map<String, String>testDataMap =testData.asMap(String.class, String.class);
		
		driver.findElement(By.id("name_3_firstname")).sendKeys(testDataMap.get("fristName"));
		driver.findElement(By.id("name_3_lastname")).sendKeys(testDataMap.get("lastName"));
		driver.findElement(By.id("phone_9")).sendKeys(testDataMap.get("phoneNumber"));
		driver.findElement(By.id("username")).sendKeys(testDataMap.get("userName"));
		System.out.println(testDataMap.toString());
		
	  
	}



}
