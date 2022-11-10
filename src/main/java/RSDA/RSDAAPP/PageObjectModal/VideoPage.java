package RSDA.RSDAAPP.PageObjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class VideoPage extends AndroidAction {
	public AndroidDriver driver;

	@FindBy(xpath = "//android.view.View[@index='0']")
	private WebElement playvideo;

	@FindBy(xpath = "//button[@class=\"btn-util label-emphasis-size-md items-center flex outlined w-full sm-min:max-w-max justify-center\"]")
	private WebElement addtobookmarkbutton;

	public VideoPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void playVideo() {
		playvideo.click();

	}

	public WebElement clickBookmarkButton() {
		return addtobookmarkbutton;
	}

}
