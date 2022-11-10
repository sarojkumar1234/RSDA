package RSDA.RSDAAPP.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import RSDA.RSDAAPP.PageObjectModal.RIDWebPage;
import RSDA.RSDAAPP.PageObjectModal.learningHubPage;
import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class Register extends setup {

	public static AndroidDriver driver;

	@Test(dataProvider = "getdata", dataProviderClass = AndroidAction.class)

	public AndroidDriver register(HashMap<String, String> input) throws Exception {

		driver = InitilizeDriver();
		RIDWebPage object = new RIDWebPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		object.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		object.clickcreateNewAccountButton();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String email = "rsdatest" + Math.random() + "@gmail.com";
		object.setEmail(email);
		object.reEnterEmail(email);

		object.createPassword(input.get("password"));

		object.reEnterPassword(input.get("password"));

		object.setFirstName(input.get("firstname"));

		object.setLastName(input.get("lastname"));

		object.clickSignUp();
		Thread.sleep(2000);
		object.clickCompleteSignUp();
		Thread.sleep(5000);
		return driver;

	}

}