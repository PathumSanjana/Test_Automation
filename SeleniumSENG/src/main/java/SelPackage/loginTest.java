package SelPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	//	WebDriverManager.edgedriver().setup();
	//	driver= new EdgeDriver();
		
	}
	
	@Test
	public void login()
	{
		driver.get("https://demo.guru99.com/V4/index.php");
	//	driver.navigate().to("https://demo.guru99.com/V4/index.php");
		driver.findElement(By.name("uid")).sendKeys("mngr495127");
		driver.findElement(By.name("password")).sendKeys("zavAhyd");
		driver.findElement(By.name("btnLogin")).click();
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='heading3']//td")));
		//assertion for validation login
		Assert.assertEquals(driver.findElement(By.xpath("//tr[@class='heading3']//td")).getText(), "Manger Id : mngr495127");
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
		driver.quit();	
	}

}
