package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Nakshatra_Finder {
	WebDriver driver = BaseClass.driver;

	@And("Select a Nakshatra Finder feature")
	public void select_Nakshatra_Feature() throws InterruptedException {
		// Select Nakshatra_Finder feature
		WebElement click_Nakshatra_Finder = driver.findElement(By.xpath("//h3[text()='Nakshatra Finder']"));
		click_Nakshatra_Finder.click();
		Thread.sleep(2000);

	}

	@And("Give the Birth Date as {string}")
	public void Birth_date(String birthdate) throws InterruptedException {
		// select Birth Date
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@id='birthDate']"));
		select_Birth_Date.click();
		select_Birth_Date.sendKeys(birthdate);
		Thread.sleep(2000);
	}

	@And("Give the Birth time as {string}")
	public void Birth_time(String birthtime) throws InterruptedException {
		// select birth time
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@id='birthTime']"));
		select_Birth_Time.sendKeys("0632AM");
		Thread.sleep(2000);
	}

	@And("Give the Birth place as {string}")
	public void Birth_Place(String birthplace) throws InterruptedException {
		// select Birth place
		WebElement select_Birth_Place = driver.findElement(By.xpath("//input[@placeholder='Enter birth place (e.g., Chennai, Mumbai)'][1]"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(birthplace);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		Thread.sleep(2000);
	}

	@When("Click on the Find Nakshatra")
	public void submit() throws InterruptedException {
		// Submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}


	@Then("Verify Success Message")
	public void verify_msg() {
		WebElement textverify = driver
				.findElement(By.xpath("//div[text()='Your birth star has been calculated successfully']"));

		System.out.println(textverify.getText());

		driver.close();

	}


	@But("Should fail in submission for Nakshatra Finder")
	public void verifyerr() throws InterruptedException {
		// Submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String err_MSG = driver.findElement(By.xpath("//div[@class='text-sm opacity-90']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(err_MSG,"Failed to find nakshatra. Please try again.");

		System.out.println("Negative Test case pased:"+err_MSG);
		Thread.sleep(1000);
		driver.quit();


	}

}
