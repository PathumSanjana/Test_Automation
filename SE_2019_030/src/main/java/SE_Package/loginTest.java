package SE_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
	//	WebDriverManager.chromedriver().setup();
	//	driver = new ChromeDriver();
		
        WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();

	}
	
	@Test
	public void login()
	{
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.findElement(By.name("email")).sendKeys("pathum@gmail.com");
		driver.findElement(By.name("password")).sendKeys("19990215");
		driver.findElement(By.name("submit")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content']//h4")));
		//assertion for validation login
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='content']//h4")).getText(), "pathum@gmail.com");
	}	
	
	@AfterMethod
	public void teardown() 
	{
		driver.close();
		driver.quit();
	}

}
