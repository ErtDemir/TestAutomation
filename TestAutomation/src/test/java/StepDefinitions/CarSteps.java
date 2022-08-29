//Author: Ertuğrul Demir
package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import junit.framework.Assert;



public class CarSteps {

	private Car car =  new Car(); 

	@Given("is in the car")
	public void is_in_the_car() {
		System.out.println("Driver in the car");
	}

	@When("the driver inserts the {int} into the car and starts it")
	public void the_driver_inserts_the_into_the_car_and_starts_it(Integer key) {
		if (car.start(key)) { 			//Driver trying to start the car 
			System.out.println("Car was started");
			car.setStarted(true);
		}
		else {
			System.out.println("Car couldn't be started");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Then("the car runs")
	public void the_car_runs() throws Throwable{
		Assert.assertTrue(car.isStarted()); //Check the car is running
	}
}
