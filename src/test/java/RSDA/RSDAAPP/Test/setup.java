package RSDA.RSDAAPP.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class setup {

	public static AndroidDriver driver;

	@Test
	public AndroidDriver InitilizeDriver() throws MalformedURLException, InterruptedException {


		UiAutomator2Options options=new UiAutomator2Options();
		options.setUdid("321014504727");
		
		options.setChromedriverExecutable("/Users/saroj.kumar/Desktop/Selenium/chromedriver");
		options.setCapability("browserName", "Chrome");
		options.setCapability(MobileCapabilityType.NO_RESET, true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,options );
		driver.get("https://stg-iniesta.ra-sports.net/");
		Thread.sleep(10000);
	    return driver;

	}


}
