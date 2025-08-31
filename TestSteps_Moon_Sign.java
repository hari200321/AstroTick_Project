package steps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.When;

public class TestSteps_Moon_Sign {
	WebDriver driver = BaseClass.driver;
	
	@And("Select a Moon Sign Feature")
	public void click_Moon_Sign() throws InterruptedException {
		WebElement click_Moon_Sign = driver.findElement(By.xpath("//h3[text()='Moon Sign']"));
		click_Moon_Sign.click();
		Thread.sleep(2000);
	}
	
	@And("Enter Your Birth date as {string}")
	public void select_Birth_date(String BirthDate) throws InterruptedException {
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@id='birthDate']"));
		select_Birth_Date.click();
		select_Birth_Date.sendKeys(BirthDate);
		Thread.sleep(2000);
	}
	
	@And("Enter Your Birth Time as {string}")
	public void select_Birth_Time(String BirthTime) throws InterruptedException {
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@id='birthTime']"));
		select_Birth_Time.sendKeys(BirthTime);
		Thread.sleep(2000);
	}
	
	@And("Enter Your Birth Place as {string}")
	public void select_Birth_Place(String BirthLocation) throws InterruptedException {
		WebElement select_Birth_Place = driver.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(BirthLocation);
		Thread.sleep(2000);
		
		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		Thread.sleep(2000);
	}

	@When("click Check Moon Sign")
	public void submit() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='Check Moon Sign']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	//Negative Scenario
	
	@When("Enter Your Born Place as {string}")
	public void enter_Place(String bornplace) throws InterruptedException {
		WebElement enter_Location = driver.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		enter_Location.sendKeys(bornplace);
		enter_Location.sendKeys(Keys.ENTER);
	}
	
	@But("Should fail for MoonSign")
	public void verify_err() throws InterruptedException {
		WebElement location = driver.findElement(By.xpath("//input[@placeholder='Enter your birth city...']"));
		String err_msg = driver.findElement(By.xpath("//div[text()='Please fill in all required fields']")).getText();
		Assert.assertEquals(err_msg, "Please fill in all required fields");
		driver.findElement(By.xpath("//button[@aria-label='Check Moon Sign']")).click();
		System.out.println("Negative Test case passed!: "+err_msg);
		driver.quit();
	}
	
}
