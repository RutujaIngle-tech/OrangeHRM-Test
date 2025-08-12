package july_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMWebsiteTest1 {

	WebDriver driver;
	String website;

	@BeforeClass // static block
	public void beforeAllMethodOnce() {
		website = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		// driver = new ChromeDriver(); // class level
		System.out.println("Start of all test cases*******");
	}

	@AfterClass
	public void afterAllMethodsOnce() {
		driver.quit();
		System.out.println("End of all test cases-----thanks*****");
	}

	@BeforeMethod // constructor
	public void beforeMethodCode() {
		driver = new ChromeDriver(); // class level
		driver.get(website); // load web page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Page is ready");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@AfterMethod

	public void afterMethodCode() {
		driver.close();
	}

	public void tc11VerifyDashboardPage() {
		String CurrentUrl = driver.getCurrentUrl();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(CurrentUrl, expUrl);
	}

	void tc12VerifyUserProfileImageisvisible() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/img"))
						.isDisplayed(),
				"logo  is not visible");
	}

	
	public void tc13VerifyTimeatWorkwidgetisvisible() {
		String check = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div"))
				.getAccessibleName();
		System.out.println(check);

	}

	
	public void tc14CheckPunchInOuttimedisplayedcorrectly() {
		String check = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/p[2]"))
				.getText();
		System.out.println(check);

	}

	@Test
	public void tc15VerifyPunchInOuticonisclickable() {
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/attendance/punchIn");
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).click();
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[3]/button")).click() ;     
	}

	
@Test
	public void tc16VerifyMyActionssection() {
	WebElement action =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div"));
	Assert.assertTrue(action.isDisplayed());

	}

	
@Test
	public void tc17CheckPendingselfreviewlink() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/p"))
				.click();

	}

	
	public void tc18Checkcandidatetointerviewlink() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/p")).click();
	}

	@Test

	public void tc19VerifyQuickLaunchoptions() {
		WebElement action =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]"));
		Assert.assertTrue(action.isDisplayed());

	}

}
