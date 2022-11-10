package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import RSDA.RSDAAPP.PageObjectModal.learningHubPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LearningHub extends Login {

	public AndroidDriver driver;
	learningHubPage object;
	 SoftAssert softassert=new SoftAssert();
	 
		
		HashMap<String, String> input;
		
		  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
		    public LearningHub(HashMap<String, String> input){
		        this.input=input;
		    }
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		driver = login(input);
		object = new learningHubPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkLearningHubDescription(HashMap<String, String> input) throws InterruptedException {

		Assert.assertEquals(object.getLearningHubDescription(), input.get("learning_hub_description"));
	}

	@Test
	public void checkSeeMyProgressLink() throws MalformedURLException, InterruptedException {

		object.clickSeeMyProgressLink();
		softassert.assertTrue(object.checkMyProgressPage().isDisplayed());
		object.clickSideBar();
		object.clickLearningHub();
		softassert.assertAll();
		

	}
	



	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void playContinueWatchingvideo(HashMap<String, String> input) throws InterruptedException {
		if (object.getpagesource(input.get("continue_watching"))) {
			object.playContinueWatchingVideo();
			int initialtime = object.getVideoTime();
			Thread.sleep(5000);
			int finaltime = object.getVideoTime();
			softassert.assertTrue(finaltime>initialtime);
			object.goBackPreviousPage();
			softassert.assertAll();
			
		}
	}

	

	@Test
	public void playPremiumVideo() throws InterruptedException {
		object.scrollAndClick("First Touch is one of the most");
		int initialtime = object.getVideoTime();
		Thread.sleep(5000);
		int finaltime = object.getVideoTime();
		
		softassert.assertTrue(finaltime>initialtime);
		object.goBackPreviousPage();
		softassert.assertAll();
		
	}
	
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class,priority=0)
	public void checkBookmarkicon(HashMap<String, String> input) throws InterruptedException
	{
		if(object.checkBookmarkIcon().isSelected())
		{
			Thread.sleep(2000);
			object.checkBookmarkIcon().click();
		    Thread.sleep(1000);
			Assert.assertTrue(object.getpagesource(input.get("add_to_bookmark")));
		}
		else
		{
			Thread.sleep(2000);
			object.checkBookmarkIcon().click();
			 Thread.sleep(1000);
				Assert.assertTrue(object.getpagesource(input.get("remove_from_bookmarks")));
			   
		}
		
	
		
	}
	
	
	

}