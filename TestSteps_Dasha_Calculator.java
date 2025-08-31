package steps;
import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Dasha_Calculator {
	WebDriver driver = BaseClass.driver;

	@And("Select a Dasha Calculator feature")
	public void Select_Dasha_Feature () throws InterruptedException {
		// Select Dasha_Calculator feature
		WebElement click_Dasha = driver.findElement(By.xpath("//h3[text()='Dasha Calculator']"));
		click_Dasha.click();
		Thread.sleep(1000);
	}

	@And("Enter Your Fullname as {string}")
	public void enter_Full_Name(String fullname) throws InterruptedException {
		// select name
		WebElement entering_Name = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));
		entering_Name.sendKeys(fullname);
		Thread.sleep(1000);
	}

	@And("Enter your DOB as {string}")
	public void Enter_Date_Of_Birth(String DateOfBirth) throws InterruptedException {
		// select Birth Date
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@name='birthDate']"));
		select_Birth_Date.click();
		select_Birth_Date.sendKeys(DateOfBirth);
		Thread.sleep(1000);
	}

	@And("Enter Your TOB as {string}")
	public void enter_Time_Of_Birth(String TimeOfBirth) throws InterruptedException {
		// select birth time
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@name='birthTime']"));
		select_Birth_Time.sendKeys(TimeOfBirth);
		Thread.sleep(2000);
	}

	@And("Enter your POB as {string}")
	public void enter_Place_Of_Birth(String PlaceOfBirth) {
		// select Birth place
		WebElement select_Birth_Place = driver.findElement(By.xpath("//input[@placeholder='Enter city name']"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(PlaceOfBirth);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
	}


	@When("Click Calculate Dasha Periods")
	public void submit() {
		driver.findElement(By.xpath("//button[text()='Calculate Dasha Periods']")).click();

		driver.quit();
	}
	
	
	//Negative scenario!
	@Then("Should fail in showing result of Dasha calci!")
	public void verify_err() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Calculate Dasha Periods']")).click();
		String err_MSG = driver.findElement(By.xpath("//p[text()='Name is required']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(err_MSG, "Name is required");
		System.out.println("Negative tes case passed:"+err_MSG);
		driver.quit();
	}
}
