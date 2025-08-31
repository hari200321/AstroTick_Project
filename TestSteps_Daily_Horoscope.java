package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
public class TestSteps_Daily_Horoscope {
	WebDriver driver = BaseClass.driver;
	
	@And("Select a Daily Horoscope feature")
	public void select_Daily_Horoscope() throws InterruptedException {
		WebElement click_Daily_Horoscope = driver.findElement(By.xpath("//h3[text()='Daily Horoscope']"));
		click_Daily_Horoscope.click();
		Thread.sleep(2000);
	}
	
	@And("Select a Mesha Sign")
	public void select_Mesha(){
		driver.findElement(By.xpath("//div[text()='Mesha']")).click();
	}
	
	@And("Select all other signs")
	public void select_Other_Signs() {
		driver.findElement(By.xpath("//span[text()='Taurus']")).click();
		driver.findElement(By.xpath("//span[text()='Gemini']")).click();
		driver.findElement(By.xpath("//span[text()='Cancer']")).click();
		driver.findElement(By.xpath("//span[text()='Leo']")).click();
		driver.findElement(By.xpath("//span[text()='Virgo']")).click();
		driver.findElement(By.xpath("//span[text()='Libra']")).click();
		driver.findElement(By.xpath("//span[text()='Scorpio']")).click();
		driver.findElement(By.xpath("//span[text()='Sagittarius']")).click();
		driver.findElement(By.xpath("//span[text()='Capricorn']")).click();
		driver.findElement(By.xpath("//span[text()='Aquarius']")).click();
		driver.findElement(By.xpath("//span[text()='Pisces']")).click();
		
		driver.quit();
	}

}
