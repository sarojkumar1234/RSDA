package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import RSDA.RSDAAPP.PageObjectModal.RIDWebPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class Login extends setup {

	public static  AndroidDriver driver;
	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)
	public AndroidDriver login(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        driver=InitilizeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		RIDWebPage object=new RIDWebPage (driver);
	    object.clickLoginButton();
	    object.setUserName(input.get("userid"));
		object.clickNextButton();
		object.setPassword(input.get("password"));
		object.clickSignIn();
		Thread.sleep(10000);
        return driver;
	}

}