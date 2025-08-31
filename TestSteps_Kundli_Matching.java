package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TestSteps_Kundli_Matching {
	WebDriver driver = BaseClass.driver;

	@And("Select a kundli Matching Feature")
	public void click_Kundli_Matching() {
		WebElement click_Kundli_Matching = driver.findElement(By.xpath("//h3[text()='Kundli Matching']"));
		click_Kundli_Matching.click();	
	}
	//Entering Boy Details

	@And("Enter Boy Name as {string}")
	public void enter_Boy_Name(String boyname) {
		WebElement entering_Boy_Name = driver.findElement(By.xpath("//input[@name='boyName']"));
		entering_Boy_Name.sendKeys(boyname);	
	}

	@And("Enter Boy BirthDate as {string}")
	public void enter_Boy_Birth_Date(String boybirthdate) {
		WebElement entering_Boy_BirthDate = driver.findElement(By.xpath("//input[@name='boyBirthDate']"));
		entering_Boy_BirthDate.click();
		entering_Boy_BirthDate.sendKeys(boybirthdate);
	}

	@And("Enter Boy Birth Time as {string}")
	public void enter_Boy_Birth_Time(String boybirthtime) {
		WebElement entering_Boy_BirthTime = driver.findElement(By.xpath("//input[@name='boyBirthTime']"));
		entering_Boy_BirthTime.sendKeys(boybirthtime);
	}

	@And("Enter Boy Birth Location as {string}")
	public void enter_Boy_Birth_Location(String boybirthlocation) throws InterruptedException {
		WebElement entering_Boy_BirthLocation = driver.findElement(By.xpath("//input[@placeholder='Enter birth place'][1]"));
		entering_Boy_BirthLocation.click();
		entering_Boy_BirthLocation.sendKeys(boybirthlocation);
		Thread.sleep(2000);
		entering_Boy_BirthLocation.click();	
	}

	//Entering Girl Details!

	@And("Enter Girl Name as {string}")
	public void enter_Girl_Name(String entergirlname) {
		WebElement entering_Girl_Name = driver.findElement(By.xpath("//input[@name='girlName']"));
		entering_Girl_Name.sendKeys(entergirlname);
	}

	@And("Enter Girl BirthDate as {string}")
	public void enter_Girl_Birth_Date(String entergirlbirthlocation) {
		WebElement entering_Girl_BirthDate = driver.findElement(By.xpath("//input[@name='girlBirthDate']"));
		entering_Girl_BirthDate.click();
		entering_Girl_BirthDate.sendKeys(entergirlbirthlocation);
	}

	@And("Enter Girl Birth Time as {string}")
	public void enter_Girl_Birth_Time(String entergirlbirthtime) {
		WebElement entering_Girl_BirthTime = driver.findElement(By.xpath("//input[@name='girlBirthTime']"));
		entering_Girl_BirthTime.sendKeys(entergirlbirthtime);
	}

	@And("Enter Girl Birth Location as {string}")
	public void enter_Girl_Birth_Location(String entergirlbirthlocation) throws InterruptedException {
		WebElement entering_Girl_BirthLocation = driver.findElement(By.xpath("(//input)[8]"));
		Thread.sleep(2000);
		entering_Girl_BirthLocation.sendKeys(entergirlbirthlocation);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();

	}


	@When("Click check compatibility")
	public void click() throws InterruptedException {

		WebElement clickthebtn = driver.findElement(By.xpath("//button[@type='submit']"));
		clickthebtn.click();
		
		//Verifying the specific text called Kundli matching Report
		WebElement result = driver.findElement(By.xpath("//h1[text()='Kundli Matching Report']"));
		//getting that Text!
		System.out.println("Successfully Generated: "+result.getText());
		driver.quit();

	}

	//For Negative Scenario!
	@But("Login Should Fail for Kundli Matching")
	public void loginShouldFail() throws InterruptedException {
		//validating error msg
		//String err_msg = driver.findElement(By.xpath("//p[@class='text-sm font-medium text-destructive']")).getText();
		//Thread.sleep(2000);
		//Assert.assertEquals(err_msg, "Girl's name is required");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println("Negative Test case passed!: "+err_msg);
		driver.quit();
	}

}

