package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Lal_Kitab {
	WebDriver driver = BaseClass.driver;


	@And("Select a LalKitab Feature")
	public void select_Lal_Kitab() throws InterruptedException {
		// Select LalKitab feature
		WebElement click_Lal = driver.findElement(By.xpath("//h3[text()='Lal Kitab Status']"));
		click_Lal.click();
		Thread.sleep(2000);
	}


	@And("Give the name in LalKitab as {string}")
	public void enter_name(String entername) {
		// select name
		WebElement entering_Name = driver.findElement(By.xpath("//input[@name='name']"));
		entering_Name.sendKeys(entername);
	}


	@And("Give the Birth Date in LalKitab as {string}")
	public void birth_Date(String DOB) throws InterruptedException {
		// select Birth Date
		WebElement select_Birth_Date = driver.findElement(By.xpath("//input[@name='birthDate']"));
		select_Birth_Date.sendKeys(DOB);
		Thread.sleep(1000);
	}


	@And("Give the Birth time in LalKitab as {string}")
	public void birth_Time(String TOB) throws InterruptedException {
		// select birth time
		WebElement select_Birth_Time = driver.findElement(By.xpath("//input[@name='birthTime']"));
		select_Birth_Time.sendKeys(TOB);
		Thread.sleep(2000);
	}


	@And("Give the Birth place in LalKitab as {string}")
	public void birth_Place(String birthplace) throws InterruptedException {
		WebElement select_Birth_Place = driver.findElement(By.xpath("//input[@placeholder='Enter birth place']"));
		select_Birth_Place.click();
		select_Birth_Place.sendKeys(birthplace);
		Thread.sleep(2000);

		// pause DOM and get the particular word from DOM
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		Thread.sleep(3000);

	}

	@When("Click on the generate lal kitab report")
	public void submit() throws InterruptedException {
		//submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.close();
	}

	
	@Then("Report generation shoud fail for Lal Kitab")
	public void verify_err() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String err_MSG = driver.findElement(By.xpath("//p[text()='Name must be at least 2 characters']")).getText();
		Assert.assertEquals(err_MSG, "Name must be at least 2 characters");
		System.out.println("Negative test case has been passed for Lal Kitab:" +err_MSG);
		driver.quit();
	}

}
