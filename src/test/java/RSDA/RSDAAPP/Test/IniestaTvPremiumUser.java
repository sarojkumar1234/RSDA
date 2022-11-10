package RSDA.RSDAAPP.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import RSDA.RSDAAPP.PageObjectModal.IniestaTVPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class IniestaTvPremiumUser extends Register {
	
	public static AndroidDriver driver;
	IniestaTVPage object;
	
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public IniestaTvPremiumUser(HashMap<String, String> input){
	        this.input=input;
	    }

	@BeforeTest
	public void setup() throws Exception {
		
		driver = register(input);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		object = new IniestaTVPage(driver);
		object.clickProfileIcon();
		object.goToHomePage();
		object.clickSideBar();
		object.clickIniestaTv();
	}

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkPremiumTag(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
		
		Assert.assertEquals(object.getPremiumTag(),input.get("label_premium") );

	}
	
	@Test
	public void playPremiumcontent() throws InterruptedException
	{
		object.scrollAndClick("This new chapter of Football");
		Assert.assertTrue(object.isAuthWallTextDisplayed().isDisplayed());
		object.goBackPreviousPage();
	}
	
	
	

}
