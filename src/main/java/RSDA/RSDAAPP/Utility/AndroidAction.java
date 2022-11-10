package RSDA.RSDAAPP.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.dsig.XMLObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidAction {
	AndroidDriver driver;

	public AndroidAction(AndroidDriver driver) {
		this.driver = driver;
	}

	public AndroidAction() {

	}

	public void scroll(String searchText) {

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + searchText + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollAndClick(String searchText) {

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + searchText + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click()", element);

	}

	public void scrollforward() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
	}

	public void waitforUrlToUpload(String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlMatches(url));

	}

	public void goBackPreviousPage() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public boolean getpagesource(String sk) {
		return driver.getPageSource().contains(sk);
	}

	public void switchNewTab() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public void switchOldTab() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	public int getVideoTime() throws InterruptedException {
		Thread.sleep(5000);
		WebElement elemen = driver
				.findElement(By.xpath("//div[@class=\"vjs-current-time vjs-time-control vjs-control\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return arguments[0].innerText;", elemen);
		text = text.replaceAll("[^0-9]", "");
		return Integer.parseInt(text);

	}

	@DataProvider(name = "getdata")
	public Object[][] getData() throws IOException {
		DataReader object = new DataReader(driver);
		List<HashMap<String, String>> data = object
				.getjsondata(System.getProperty("user.dir") + "/src/test/java/RSDA/RSDAAPP/TestData/RSDA.json");
		return new Object[][] { { data.get(0) } };
	}

	public String getScreenShotPath(String testCaseName, AppiumDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/src/RSDA_REPORTS/screenshot/" + testCaseName
				+ ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
