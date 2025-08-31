package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Daily_Panchang {
	WebDriver driver = BaseClass.driver;

	@And("Select Daily Panchang Feature")
	public void click_Daily_Panchang() {
		WebElement click_Daily_Punchang = driver.findElement(By.xpath("//h3[text()='Daily Panchang']"));
		click_Daily_Punchang.click();
	}

	@And("Entering date as {string}")
	public void enter_Date(String enteringDate) {
		WebElement enterDate = driver.findElement(By.xpath("//input[@id='date']"));
		enterDate.click();
		enterDate.sendKeys(enteringDate);
	}
	
	@And("Entering City")
	public void enter_City() {
		WebElement enterCity = driver.findElement(By.xpath("//button[@role='combobox'][1]"));
		enterCity.click();
		driver.findElement(By.xpath("//div[text()='Mumbai']")).click();
	}

	@When("Click Calculate Panchang")
	public void submit() {
		driver.findElement(By.xpath("//button[text()='Calculate Panchang']")).click();

		driver.quit();

	}
	
	@But("Should fail for Daily Panchang")
	public void verify_err() throws InterruptedException {
		String err_msg = driver.findElement(By.xpath("//p[@class='text-red-700 font-medium']")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(err_msg, "Failed to calculate panchang");
		driver.findElement(By.xpath("//button[text()='Calculate Panchang']")).click();
		System.out.println("Negative Test case passed!: "+err_msg);
		driver.quit();
	}


}
