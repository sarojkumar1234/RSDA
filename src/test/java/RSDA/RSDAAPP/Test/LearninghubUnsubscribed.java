package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import RSDA.RSDAAPP.PageObjectModal.IniestaTVPage;
import RSDA.RSDAAPP.PageObjectModal.learningHubPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class LearninghubUnsubscribed extends Register {

	public AndroidDriver driver;
	learningHubPage object;
	
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public LearninghubUnsubscribed(HashMap<String, String> input){
	        this.input=input;
	    }
	
	@BeforeTest
	public void setup() throws Exception {
		
		driver = register(input);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		object = new learningHubPage(driver);
		object.clickProfileIcon();
		object.goToHomePage();
		Thread.sleep(2000);
	  
	}
	@AfterMethod
	public void goToLearningHubPage()
	{
		object.clickSideBar();
		object.clickLearningHub();
	}
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkFreeTag(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
		object.scroll("Premium");
		Assert.assertEquals(object.getFreeTag(),input.get("label_free"));

	}

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkPremiumTag(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
	Assert.assertEquals(object.getPremiumTag(),input.get("label_premium") );

	}
    

	@Test
	public void playFreeVideo() throws InterruptedException {
		object.scrollAndClick("Polish your ground pass skills");
		int initialtime = object.getVideoTime();
		Thread.sleep(3000);
		int finaltime = object.getVideoTime();
		Assert.assertTrue(finaltime > initialtime);
		object.goBackPreviousPage();

	}

	@Test
	public void playPremiumVideo() throws InterruptedException {
		object.scrollAndClick("Good body placement");
		Assert.assertTrue(object.isAuthWallTextDisplayed().isDisplayed());
		object.goBackPreviousPage();
	}


}
