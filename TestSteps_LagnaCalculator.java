package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_LagnaCalculator {
	WebDriver driver = BaseClass.driver;

	@And("Select a Lagna Calculator feature")
	public void select_Lagna_feature() {
		// Select Lagna_Calculator feature
		WebElement click_Lagna = driver.findElement(By.xpath("//h3[text()='Lagna Calculator']"));
		click_Lagna.click();
	}

	@And("Enter your DOB in lagna as {string}")
	public void enter_Dateofbirth(String DOB) throws InterruptedException {
		// select Birth Date
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@id='birthDate']"));
		select_Birth_Date.click();
		select_Birth_Date.sendKeys(DOB);
		Thread.sleep(2000);
	}

	@And("Enter Your TOB in lagna as {string}")
	public void enter_Timeofbirth(String TOB) throws InterruptedException {
		// select birth time
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@id='birthTime']"));
		select_Birth_Time.sendKeys(TOB);
		Thread.sleep(2000);
	}

	@And("Enter your POB in lagna as {string}")
	public void place_Of_Birth(String POB) throws InterruptedException {
		// select Birth place
		WebElement select_Birth_Place = driver
				.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(POB);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		Thread.sleep(2000);
	}
	
	@When("Click Calculate Lagna Periods")
	public void submit() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Calculate Lagna']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	//Negative Scenario
	@Then("Calculate lagna should fail")
	public void verify_err() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Calculate Lagna']")).click();
		Thread.sleep(1000);
		
		String err_MSG = driver.findElement(By.xpath("//div[@class='text-sm opacity-90']")).getText();
		Assert.assertEquals(err_MSG, "Failed to calculate lagna. Please try again.");
		System.out.println("Negative test case passed:"+err_MSG);
		
		driver.quit();
	}
	

}
