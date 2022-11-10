package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import RSDA.RSDAAPP.PageObjectModal.IniestaTVPage;
import RSDA.RSDAAPP.PageObjectModal.learningHubPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import dev.failsafe.internal.util.Durations;
import io.appium.java_client.android.AndroidDriver;

public class IniestaTv extends Login {

	public  AndroidDriver driver;
	IniestaTVPage object;
	SoftAssert softAssert = new SoftAssert();
	
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public IniestaTv(HashMap<String, String> input){
	        this.input=input;
	    }
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		driver = login(input);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		object = new IniestaTVPage(driver);
		object.clickSideBar();
		object.clickIniestaTv();
	}

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkDescription(HashMap<String, String> input) throws InterruptedException
	{
		
		Assert.assertEquals(object.getIniestaTVDescription(), input.get("learning_hub_description"));
	}
	
	@Test
	private void playIniestaVideo() throws InterruptedException {
		object.scrollAndClick("This new chapter of Football Skills");
		Thread.sleep(5000);
		int initialtime = object.getVideoTime();
		Thread.sleep(3000);
		int finaltime = object.getVideoTime();
		softAssert.assertTrue(finaltime > initialtime);
		object.goBackPreviousPage();
		softAssert.assertAll();
	}
	

}