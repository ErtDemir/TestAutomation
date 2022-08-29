//Author: Ertuğrul Demir
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

public class GoogleSteps {
	
	WebDriver driver = null;
	private String BASE_URL =  "https://encrypted.google.com/webhp?hl=en&gl=en#safe=active&hl=en&gl=en&q=%s";
								//If I write just google.com , page will be Turkish and just navigate us to sahibinden.com
	

	@Given("is in google.com")
	public void is_in_google_com() {
		String projectPath = System.getProperty("user.dir"); //get the project path because code should be able to run on every system

		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //we use timeouts for not waiting so much if it is wrong
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); 							  //Fullscreen mode
		driver.navigate().to(BASE_URL);
	}

	@When("user enters tesla and clicks on I am feeling lucky button")
	public void user_enters_tesla_and_clicks_on_i_am_feeling_lucky_button() {
	    driver.findElement(By.name("q")).sendKeys("tesla");  //enters "tesla" in search bar
	    driver.findElement(By.name("btnI")).click(); 		 // clicks "I'm feeling lucky" button
	}

	@SuppressWarnings("deprecation")
	@Then("Check if HTML Title element value contains {string}")
	public void check_if_html_title_element_value_contains(String string) throws Throwable{
	    Boolean condition = driver.getPageSource().contains(string);  //Search the string that we want to find
	    
	    driver.close();											      //Close the browser
		driver.quit();
		
		Assert.assertTrue(condition);								  // Control if the condition is true
	}

	
}
