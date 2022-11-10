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


import RSDA.RSDAAPP.PageObjectModal.VideoPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.sdk.metrics.data.Data;

public class VideoPlayer extends Login {
	



	public  AndroidDriver driver;
	VideoPage object;
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public VideoPlayer(HashMap<String, String> input){
	        this.input=input;
	    }
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		driver = login(input);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		object = new VideoPage (driver);
	}

	
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkBookmarkButton(HashMap<String, String> input) throws InterruptedException
	{	object.scrollAndClick("Polish your ground pass skills");
	     object.scroll("Learning Hub");
		if(object.clickBookmarkButton().isDisplayed())
		{
			Thread.sleep(2000);
			 object.clickBookmarkButton().click();
			 Thread.sleep(1000);
		    Assert.assertTrue(object.getpagesource(input.get("add_to_bookmark")));
		}
		else
		{
			Thread.sleep(2000);
			 object.clickBookmarkButton().click();
			 Thread.sleep(1000);
		    Assert.assertTrue(object.getpagesource(input.get("remove_from_bookmarks")));
	}
	
}
	
}
	