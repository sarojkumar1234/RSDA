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

import RSDA.RSDAAPP.PageObjectModal.IniestaTVPage;
import RSDA.RSDAAPP.PageObjectModal.MyProgressPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class myprogress extends Login {

	public AndroidDriver driver;
	MyProgressPage object;

	
	HashMap<String, String> input;
	
	  @Factory(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	    public myprogress(HashMap<String, String> input){
	        this.input=input;
	    }
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		driver = login(input);
		object = new MyProgressPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		object.clickSideBar();
		object.clickMyProgress();
	}

	@Test
	public void checkOverview() throws InterruptedException {
		
		object.scroll("Overview");
	  Assert.assertEquals(object.sumofchannelVideos(), object.LessonsCompleted());
	}



	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkMyBookmarks(HashMap<String, String> input) throws InterruptedException {
		object.scroll("My Bookmarks");
		if(object.bookmarkicon.size()==0)
		{
			Assert.assertTrue(object.getpagesource(input.get("empty_bookmark_alert")));
		}
		else
		{
			Assert.assertTrue(object.bookmarkicon.size()>0);
		}
			
		
	}
	

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public void checkCompleted(HashMap<String, String> input) throws InterruptedException {
		object.scroll("Lessons completed");
		if(object.bookmarkicon.size()==0)
		{
			Assert.assertTrue(object.getpagesource(input.get("empty_completed_alert")));
		}
		else
		{
			Assert.assertTrue(object.bookmarkicon.size()>0);
		}
			
		
	}
	

}
