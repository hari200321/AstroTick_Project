package steps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Numerology{
	WebDriver driver = BaseClass.driver;
	
	@And("select a Numerology")
	public void click_numerology() throws InterruptedException {
		WebElement click_Numerology = driver.findElement(By.xpath("//h3[text()='Numerology']"));
		click_Numerology.click();
		Thread.sleep(1000);
	}
	
	@And("Enter the name as {string}")
	public void entering_Name(String entername) throws InterruptedException {
		WebElement enter_Name = driver.findElement(By.xpath("//input[@id='name']"));
		enter_Name.sendKeys(entername);
		Thread.sleep(1000);
	}
	@And("Enter the Date of Birth as {string}")
	public void entering_BirthDate(String enterBirthdate) throws InterruptedException {
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@id='birthDate']"));
		select_Birth_Date.click();
		select_Birth_Date.sendKeys(enterBirthdate);
		Thread.sleep(1000);
		
	}
	
	@When("Click calculate my numbers")
	public void click_submit() {
		driver.findElement(By.xpath("//button[text()='Calculate My Numbers'][1]")).click();
		
	}
	@Then("Verify message")
	public void verify_msg() {
		WebElement success_message = driver.findElement(By.xpath("//h3[text()='Your Numerology Results']"));
		System.out.println(success_message.getText());
		driver.quit();
	}
	
	@But("Login should fail for Numerology")
	public void verify_err() {
		
		driver.findElement(By.xpath("//button[text()='Calculate My Numbers'][1]")).click();
		driver.quit();
	}
	

}
