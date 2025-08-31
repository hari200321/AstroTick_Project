package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps_Free_Kundli {

	@Given("Open the Chrome Browser")
	public void openBrowser() {
		BaseClass.driver = new ChromeDriver();
		BaseClass.driver.manage().window().maximize();
		BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("Load the website URL as {string}")
	public void load_Url(String url) {
		BaseClass.driver.get(url);
	}

	@And("Select a Free kundli Feature")
	public void click_Free_Kundli() {
		WebElement kundli_element = BaseClass.driver.findElement(By.xpath("//h3[text()='Free Kundli']"));
		kundli_element.click();		
	}

	@And("Enter Name")
	public void enter_Name() {
		WebElement enter_Name = BaseClass.driver.findElement(By.xpath("//input[@id='birth-name']"));
		enter_Name.sendKeys("HariPrasad");	
	}

	@And("Select Gender")
	public void select_Gender() {
		WebElement select_Gender = BaseClass.driver.findElement(By.xpath("//select[@id='birth-gender'][1]"));
		select_Gender.click();

	}

	@And("Enter Birth date as {string}")
	public void enter_Birth_Date(String birth_date) {
		WebElement select_BirthDate = BaseClass.driver.findElement(By.xpath("//input[@id='birth-date']"));
		select_BirthDate.click();
		select_BirthDate.sendKeys(birth_date);
	}

	@And("Enter Birth Time as {string}")
	public void enter_Birth_Time(String birth_time) {
		WebElement select_BirthTime = BaseClass.driver.findElement(By.xpath("//input[@id='birth-time']"));
		select_BirthTime.click();
		select_BirthTime.sendKeys(birth_time);
	}

	@And("Enter Birth Location")
	public void enter_Birth_Locatoin() {
		WebElement select_BirthLocation = BaseClass.driver.findElement(By.xpath("//input[@id='birth-location']"));
		select_BirthLocation.click();
		select_BirthLocation.sendKeys("Chennai");
		select_BirthLocation.click();
	}

	@When("Click on Generate Birth Chart")
	public void click() {
		WebElement select_Submit = BaseClass.driver.findElement(By.xpath("//div[text()='Generate Birth Chart']"));
		select_Submit.click();
	}

	@Then("Verify Generate message")
	public void verify_Msg() {
		//Verifying the specific text called chart generated successfully
		WebElement get_result = BaseClass.driver.findElement(By.xpath("//h3[text()='Chart Generated Successfully!']"));

		//getting that Text!
		System.out.println(get_result.getText());
		BaseClass.driver.quit();
	}
	
	@But("Login should fail for FreeKundli")
	public void verify_Error_msg() {
		WebElement select_Submit = BaseClass.driver.findElement(By.xpath("//div[text()='Generate Birth Chart']"));
		select_Submit.click();
		BaseClass.driver.quit();
	}

}
