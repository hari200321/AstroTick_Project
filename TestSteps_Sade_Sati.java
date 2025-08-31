package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Sade_Sati {

	WebDriver driver = BaseClass.driver;

	@And("Select a Sade Sati Feature")
	public void select_Sade_feature() throws InterruptedException {
		// Select Sadi Sati feature
		WebElement sadi_Sati = driver.findElement(By.xpath("//h3[text()='Sade Sati Calculator']"));
		sadi_Sati.click();
		Thread.sleep(2000);
	}

	@And("Give the name in SadeSati as {string}")
	public void give_Name(String entername) throws InterruptedException {
		//entering Name
		WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));
		fullName.click();
		fullName.sendKeys(entername);
		Thread.sleep(2000);
	}


	@And("Give the Birth Date in SadeSati as {string}")
	public void birth_Date(String DOB) throws InterruptedException {
		// select Birth Date
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@name='birthDate']"));
		// select_Birth_Date.click();
		select_Birth_Date.sendKeys(DOB);
		Thread.sleep(1000);
	}


	@And("Give the Gender in SadeSati as {string}")
	public void enter_gender(String entergender) throws InterruptedException {
		//entering Gender
		WebElement enter_Gender = driver.findElement(By.xpath("//button[@role='combobox']"));
		enter_Gender.sendKeys(entergender);
		Thread.sleep(2000);

	}


	@And("Give the Birth time in SadeSati as {string}")
	public void enter_Birth_time(String TOB) throws InterruptedException {
		// select birth time
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@name='birthTime']"));
		select_Birth_Time.sendKeys(TOB);
		Thread.sleep(2000);

	}


	@And("Give the Birth place in SadeSati as {string}")
	public void birth_Place(String birthplace) throws InterruptedException {
		// select Birth place
		WebElement select_Birth_Place = driver.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(birthplace);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Singapore']")).click();
		Thread.sleep(3000);
	}


	@When("Click on the calculate Sade Sati")
	public void submit() {
		//submit
		driver.findElement(By.xpath("//button[text()='Calculate Sade Sati']")).click();

		driver.close();

	}
	
	@Then("Calculate Sade Sati should fail")
	public void verify_err() {
		driver.findElement(By.xpath("//button[text()='Calculate Sade Sati']")).click();
		
		String err_MSG = driver.findElement(By.xpath("//p[text()='Birth date is required']")).getText();
		Assert.assertEquals(err_MSG, "Birth date is required");
		System.out.println("Negative test case passed for Sade Sati:" + err_MSG);
		driver.quit();
	}


}
