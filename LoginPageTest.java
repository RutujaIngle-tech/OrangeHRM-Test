package july_25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver;
	String website;
	
	@BeforeClass      // static block
	public void beforeAllMethodOnce() {
		website = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		// driver = new ChromeDriver();  // class level
		System.out.println("Start of all test cases*******");
	}
	
	@AfterClass
    public void afterAllMethodsOnce() {
		driver.quit();
		System.out.println("End of all test cases-----thanks*****");
	}
	
	@BeforeMethod // constructor
	public void beforeMethodCode() {
		driver = new ChromeDriver();  // class level
		driver.get(website);  // load web page
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Page is ready");
	}
	
	 @AfterMethod
	 
	 public void afterMethodCode() {
		driver.close();
	}
	
  @Test
  public void Test01LoginPageTitle() {
	  String actTitle = driver.getTitle();
	  String expTitle = "OrangeHRM";  // excel code
	  Assert.assertEquals(actTitle, expTitle);
  
  }
  @Test
  public void Test02LoginValid() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String CurrentUrl = driver.getCurrentUrl();
	  String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  Assert.assertEquals(CurrentUrl, expUrl);

  }
  
  @Test
  public void Test03LoginInvalid() {
	  driver.findElement(By.name("username")).sendKeys("Rutuja");
	  driver.findElement(By.name("password")).sendKeys("rutuja123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String CurrentUrl = driver.getCurrentUrl();
	  String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  Assert.assertEquals(CurrentUrl, expUrl);
	  
  }
  
  @Test
  public void Test04InvalidPssword() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String loginerror =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
	  String expLoginerror = "Invalid credentials";
	  Assert.assertEquals(loginerror, expLoginerror);
  }
  
  @Test
  public void Test05EmptyUsername() {
	  driver.findElement(By.name("username")).sendKeys("");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String loginerror =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
	  String expLoginerror = "Required";
	  Assert.assertEquals(loginerror, expLoginerror);
	  
  }
  
  @Test
  public void Tc06Emptypassword() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String loginerror =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")).getText();
	  String expLoginerror = "Required";
	  Assert.assertEquals(loginerror, expLoginerror);
}
  
  @Test
  public void tc07Bothfieldsempty() {
	  driver.findElement(By.name("username")).sendKeys("");
	  driver.findElement(By.name("password")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  String loginerror1 =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
	  String loginerror2 =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")).getText();
	  String expLoginerror = "Required";
	  Assert.assertEquals(loginerror1, expLoginerror);
	  Assert.assertEquals(loginerror2, expLoginerror);

}
  
  @Test
 public void tc08CheckForgotpasswordlink() {
	 
	 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
	 String CurrentUrl = driver.getCurrentUrl();
	 String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
	 Assert.assertEquals(CurrentUrl, expUrl); 
	
}
  
  @Test
  public void  tc09UIelementsvisibility() {
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]")).isDisplayed(),"logo is not visible");
	  Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed(),"username not visible");
	  Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed(),"password not visible");
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).isDisplayed(),"");
}
  @Test
  public void tc10Passwordmasking() {
	  String act = driver.findElement(By.name("password")).getTagName();
	  System.out.println(act);
	 
	  
}
	
}

 
	  
	 


