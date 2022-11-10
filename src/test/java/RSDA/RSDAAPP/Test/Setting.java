package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.dsig.XMLObject;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import RSDA.RSDAAPP.PageObjectModal.IniestaTVPage;
import RSDA.RSDAAPP.PageObjectModal.SettingPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import RSDA.RSDAAPP.Utility.DataReader;
import io.appium.java_client.android.AndroidDriver;

public class Setting extends Login {
	



	public  AndroidDriver driver;
	SettingPage object;
	
	
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public Setting(HashMap<String, String> input){
	        this.input=input;
	    }
	@BeforeTest
      public void setup() throws MalformedURLException, InterruptedException {
		driver = login(input);
		object = new SettingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		object.clickSideBar();
	    object.clickSetting();
	}
	
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkPaymentStatus(HashMap<String, String> input) throws InterruptedException
	{
       object.clickDropdown();
       object.clickPaymentStatus();
       Thread.sleep(1000);
	   Assert.assertTrue(object.getpagesource(input.get("label_order_paid")));
	   
	}
	
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkSubscriptionStatus(HashMap<String, String> input) throws InterruptedException
	{
		object.clickDropdown();
		object.clickSubscriptionStatus();
		Assert.assertTrue(object.getpagesource(input.get("label_subscription_active")));

	}
	
@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class,priority=3)
public void checkEditOnMyRakuten(HashMap<String, String> input) throws InterruptedException
{
	object.clickDropdown();
    object.clickPersonalInformation();
	object.clickEditOnMyRakuten();
	object.clickSignOutAndEditButton();
	object.switchNewTab();
	object.waitforUrlToUpload(input.get("Edit_page_url"));
	Assert.assertEquals(driver.getCurrentUrl(), input.get("Edit_page_url"));
	object.switchOldTab();
	object.goBackPreviousPage();
}




	

	
	
}
	



	