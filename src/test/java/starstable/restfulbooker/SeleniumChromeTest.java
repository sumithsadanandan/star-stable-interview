package starstable.restfulbooker;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import starstable.pageobjects.AlertObjects;
import starstable.pageobjects.HomePage;

public class SeleniumChromeTest {

	private static ChromeDriverService service;

	private WebDriver driver;


	@BeforeClass
	public static void createAndStartService() {
		try {
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File("chromedriver.exe")).usingAnyFreePort()
				.build();
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void createDriver() {

		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		PageFactory.initElements(this.driver, this);
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	@Test
	public void testContactUS() throws InterruptedException {
		driver.get("https://automationintesting.online");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		HomePage homePage=new HomePage(driver);
		homePage.populateContactName("Sumith");
		homePage.populateEmail("123124@email.com");
		homePage.populatePhoneNumber("123456789012");
		homePage.populateSubject("Test subject for automation test");
		homePage.populateDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue " +
				"eu purus ut consequat. Mauris sed nisl ut risus dignissim dignissim ac sit amet eros. " +
				"Donec sem arcu, interdum ac accumsan eget.");

		homePage.clickSubmit();
		Thread.sleep(10000);
	}


	@Test
	public void testContactUSWithoutValidSubject() throws InterruptedException {
		driver.get("https://automationintesting.online");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		HomePage homePage=new HomePage(driver);
		AlertObjects alert =new AlertObjects(driver);
		homePage.populateContactName("Sumith");
		homePage.populateEmail("123124@email.com");
		homePage.populatePhoneNumber("123456789012");
		homePage.populateDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue " +
				"eu purus ut consequat. Mauris sed nisl ut risus dignissim dignissim ac sit amet eros. " +
				"Donec sem arcu, interdum ac accumsan eget.");
		homePage.clickSubmit();
		Thread.sleep(10000);
		alert.isAlerted();
		Assert.assertEquals(alert.getAlertText(),"Subject may not be blank\n" +
				"Subject must be between 5 and 100 characters.");
	}

	@Test
	public void testRoomBooking() throws InterruptedException {
		driver.get("https://automationintesting.online");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		HomePage homePage=new HomePage(driver);
		AlertObjects alert =new AlertObjects(driver);
		homePage.bookRoom();
		homePage.bookRoom_populateName("Nanda");
		homePage.bookRoom_populateLastName("Kumar");
        homePage.bookRoom_populateEmail("fsdfs@gmail.com");
        homePage.bookRoom_populatePhone("12345678987");
		homePage.getElementForCalendar();
		Thread.sleep(10000);
		homePage.bookRoom_submit();
		alert.isAlertedBooking();
		Assert.assertEquals(alert.getAlertTextBooking(),"must not be null\n" +
				"must not be null");

	}


}