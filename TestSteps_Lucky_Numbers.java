package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Lucky_Numbers {
	WebDriver driver = BaseClass.driver;

	@And("Select a Lucky Nmber Feature")
	public void click_LuckyNumber_feature() throws InterruptedException {
		// Select LuckyNumber_Calculator feature
		WebElement click_Lucky = driver.findElement(By.xpath("//h3[text()='Lucky Numbers']"));
		click_Lucky.click();

		Thread.sleep(3000);
	}

	@And("Give the name in LN as {string}")
	public void enter_name(String entername) throws InterruptedException {
		// Enter name
		WebElement enter_Name = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));
		enter_Name.sendKeys(entername);
		Thread.sleep(2000);
	}

	@And("Give the Gender in LN as {string}")
	public void enter_gender(String entergender) throws InterruptedException {
		// enter_gender
		WebElement enter_Gender = driver.findElement(By.xpath("//button[@role='combobox']"));
		enter_Gender.sendKeys(entergender);
		Thread.sleep(2000);
	}

	@And("Give the Birth Date in LN as {string}")
	public void birth_Date(String DOB) throws InterruptedException {
		// Birth_Date
		WebElement BirthDate = driver.findElement(By.id("birthDate"));
		BirthDate.sendKeys(DOB);
		Thread.sleep(2000);
	}


	@And("Give the Birth time in LN as {string}")
	public void birth_Time(String TOB) throws InterruptedException {
		// Birth_Time
		WebElement BirthTime = driver.findElement(By.id("birthTime"));
		BirthTime.sendKeys(TOB);
		Thread.sleep(2000);
	}


	@And("Give the Birth place in LN as {string}")
	public void place_Of_Birth(String placeofbirth) throws InterruptedException {
		// Birth_Place
		WebElement BirthPlace =
				driver.findElement(By.xpath("//input[@placeholder='Enter birth place']"));
		BirthPlace.sendKeys(placeofbirth);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		Thread.sleep(2000);
	}

	@When("Click on the Generate Lucky Numbers")
	public void submit() throws InterruptedException {
		//submit
		driver.findElement(By.xpath("//button[text()='Generate Lucky Numbers']")).click();
		Thread.sleep(2000);
	}

	@Then("verify success message in lucky number feature")
	public void verify_MSG() {
		//Verifying the specific text called chart generated successfully
		WebElement get_result = driver.findElement(By.xpath("//div[text()='Your personalized lucky numbers are ready']"));

		//getting that Text!
		System.out.println(get_result.getText());

		driver.close();
	}



	//Negative Scenario
	@But("Should throw error while click the Generate Button")
	public void verify_err() {
		//submit
		driver.findElement(By.xpath("//button[text()='Generate Lucky Numbers']")).click();
		
		String err_MSG = driver.findElement(By.xpath("//div[@class='text-sm opacity-90']")).getText();
		Assert.assertEquals(err_MSG, "Please fill in all required fields");
		
		System.out.println("Negative test has been passed for Lucky number generator: "+err_MSG);
		driver.quit();
	
	}
}
