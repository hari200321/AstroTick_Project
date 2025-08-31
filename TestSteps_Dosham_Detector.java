package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Dosham_Detector {
	WebDriver driver = BaseClass.driver;

	@And("Select a Dosham Detector feature")
	public void select_Dosham_Feature() {
		// Select Dosham_Deetector feature
		WebElement click_Dosham = driver.findElement(By.xpath("//h3[text()='Dosham Detector']"));
		click_Dosham.click();
	}

	@And("Give the name in Dosham as {string}")
	public void enter_Name(String enteryourname) {
		// enter full name
		WebElement enter_Name = driver.findElement(By.xpath("//input[@id='name']"));
		enter_Name.sendKeys(enteryourname);
	}

	@And("Give the Birth Date in Dosham as {string}")
	public void birth_Date(String DOB) {
		WebElement select_BirthDate = driver.findElement(By.xpath("//input[@id='birthDate']"));
		select_BirthDate.sendKeys(DOB);
	}

	@And("Give the Gender in Dosham as {string}")
	public void select_Gender(String choosegender) {
		WebElement select_Gender = driver.findElement(By.xpath("//button[@role='combobox']"));
		select_Gender.sendKeys(choosegender);
	}

	@And("Give the Birth time in Dosham as {string}")
	public void select_Time_Of_Birth(String TOB) {
		WebElement select_BirthTime = driver.findElement(By.xpath("//input[@id='birthTime']"));
		select_BirthTime.click();
		select_BirthTime.sendKeys(TOB);
	}

	@And("Give the Birth place in Dosham as {string}")
	public void birth_PLace(String placeofbirth) throws InterruptedException {
		WebElement select_BirthLocation = driver
				.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		select_BirthLocation.sendKeys("Chennai");
		Thread.sleep(1000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
	}


	@When("Click on the Detect Dosham")
	public void submit() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}


	@Then("Verify Success Message for Dosham Feature")
	public void verify_MSG() {
		WebElement getResultText = driver
				.findElement(By.xpath("//div[text()='Your dosha analysis has been completed successfully']"));

		System.out.println(getResultText.getText());

		driver.quit();
	}


	
	//Negative Scenario
	@But("Detect Dosham should be Fail")
	public void verify_err() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		//String err_msg = driver.findElement(By.xpath("//div[text()='Please fill in all required fields']")).getText();
		//Assert.assertEquals(err_msg, "Please fill in all required fields");
		//System.out.println("Negative test case passed for Dosham_Detector:"+ err_msg);
		//Thread.sleep(2000);
		driver.quit();
	}
}
