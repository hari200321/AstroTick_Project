package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class TestSteps_Baby_Name_Gen {
	WebDriver driver = BaseClass.driver;


	@And("Select a Babyname Generator Feature")
	public void select_Baby_Name_Feature() throws InterruptedException {
		// Select Baby-Name Generator feature
		WebElement click_Baby = driver.findElement(By.xpath("//h3[text()='Baby Name Generator']"));
		click_Baby.click();

		Thread.sleep(2000);
	}

	@And("Give the Birth Date in Babyname feature as {string}")
	public void birth_Date(String DOB) throws InterruptedException {
		//select BirthDate
		driver.findElement(By.id("birthDate")).sendKeys(DOB);
		Thread.sleep(2000);
	}


	@And("Give the Birth time in Babyname feature as {string}")
	public void birth_Time(String TOB) throws InterruptedException {
		//select Birth Time
		driver.findElement(By.id("birthTime")).sendKeys(TOB);
		Thread.sleep(2000);

	}


	@And("Give the Birth place in Babyname feature as {string}")
	public void birth_Place(String placeofbirth) throws InterruptedException {
		//enter Place
		WebElement enter_City_Name = driver.findElement(By.xpath("//input[@placeholder='Start typing city name...']"));
		enter_City_Name.click();
		enter_City_Name.sendKeys(placeofbirth);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Yongkang']")).click();
	}


	@And("select the Gender in BabyName feature")
	public void select_Gender() throws InterruptedException {
		// selectGender
		WebElement select_Gender = driver.findElement(By.xpath("//button[@role='combobox']"));
		select_Gender.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Boy']")).click();
		//Thread.sleep(2000);

	}

	@When("Click on the Suggest Report")
	public void submit() {
		//submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}


	@Then("Verify success message for baby name feature")
	public void verify_MSG() {
		//Verify success message
		WebElement verify_Message = driver.findElement(By.xpath("//div[text()='Names Generated']"));
		System.out.println(verify_Message.getText());
		driver.quit();

	}
	
	//Negative Scenario!
	@But("verify error message for baby name feature")
	public void verify_err() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String err_MSG = driver.findElement(By.xpath("//div[@class='text-sm opacity-90']")).getText();	
		Assert.assertEquals(err_MSG, "Failed to generate names. Please try again.");
		System.out.println("Negative test has been passed for Baby name suggester:" +err_MSG);
		driver.quit();
	}

}
