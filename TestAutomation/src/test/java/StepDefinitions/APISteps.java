//Author: Ertuğrul Demir
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.json.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import junit.framework.Assert;

public class APISteps {

	WebDriver driver = null;
	private String BASE_URL =  "https://gorest.co.in";
	private JSONObject jsonobject = null ;
	
	@Given("is in gorest.co.in website")
	public void is_in_gorest_co_in_website() {
		String projectPath = System.getProperty("user.dir");  //get the project path because code should be able to run on every system

		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //we use timeouts for not waiting so much if it is wrong
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); 							  //Fullscreen mode
		driver.navigate().to(BASE_URL);
	}

	@When("send a get request to the endpoint users")
	public void send_a_get_request_to_the_endpoint_users() {
		driver.get(BASE_URL+"/public/v2/users"); 	//Get request to "public/v2/users" path
	}

	@SuppressWarnings("deprecation")
	@When("get the user details that users id is {int}")
	public void get_the_user_details_that_users_id_is(Integer id) throws Throwable{
		String preText = driver.findElement(By.xpath(".//pre")).getText(); 	//Get text in pre-part of page source
		JSONArray jsonarray = new JSONArray(preText);						//Create the json array using the text
		for (int i = 0; i < jsonarray.length(); i++) {						//Try to find object that id is correct
			 jsonobject = jsonarray.getJSONObject(i);
			 if(jsonobject.getInt("id") == id) {
				 break;
			 }
		}
		if (jsonobject.getInt("id") != id) {								// If we cannot find them, this part returns failed
			System.out.println("There is no user that id is"+id.toString());
			
			driver.close();													//Close the browser
			driver.quit();
			
			Assert.assertTrue(false);										//Returns failed
			
		}
	}

	@SuppressWarnings("deprecation")
	@Then("check the gender is female and status is active")
	public void check_the_gender_is_female_and_status_is_active() throws Throwable{
										//Checking part
		Boolean condition = jsonobject.get("gender").equals("female") && jsonobject.get("status").equals("active");
		
		driver.close();	  				//Close the browser													
		driver.quit();
		
		Assert.assertTrue(condition);	// Control if the condition is true
	}

}
