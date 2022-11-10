package RSDA.RSDAAPP.PageObjectModal;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class learningHubPage extends AndroidAction {
	public AndroidDriver driver;

	@FindBy(linkText = "See my progress")
	private WebElement seemyprogress;

	@FindBy(xpath = "//div/span/img")
	private WebElement clickcontinuewatchingvideo;

	@FindBy(xpath = "//android.view.View[@index='0']")
	private WebElement playvideo;

	@FindBy(xpath = "//button[@data-testid=\"user-profile-header\"]")
	private WebElement profileicon;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement homepage;

	@FindBy(xpath = "//p[contains(text(),'Learning Hub offers 2-5 minute point lessons')]")
	private WebElement learninghubdescription;

	@FindBy(xpath = "//span[contains(text(),'My Progress')]")
	private WebElement myprogresspage;

	@FindBy(xpath = "//span[contains(text(),'Premium')]")
	private WebElement premiumtag;

	@FindBy(xpath = "//div[contains(text(),'Free')]")
	private WebElement freetag;

	@FindBy(xpath = "//button[@class=\"ml-spacer-300 s-min:hidden absolute left-[5px]\"]")
	private WebElement sidebar;

	@FindBy(xpath = "//span[contains(text(),'Learning Hub')]")
	private WebElement learninghub;

	@FindBy(className = "headline-size-sm")
	private WebElement authwalltext;
	
	@FindBy(xpath = "//button[@class=\" absolute right-spacer-200 top-0 z-10\"]")
	public List<WebElement> bookmarkicon;

	public learningHubPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSeeMyProgressLink() {
		seemyprogress.click();
	}

	public WebElement checkMyProgressPage() {
		return myprogresspage;
	}

	public void clickLearningHub() {
		learninghub.click();
	}

	public void playContinueWatchingVideo() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickcontinuewatchingvideo);

	}

	public void playVideo() {
		playvideo.click();

	}

	public String getLearningHubDescription() {
		return learninghubdescription.getText();
	}

	public WebElement isAuthWallTextDisplayed() {
		return authwalltext;
	}

	public void clickSideBar() {
		sidebar.click();
	}

	public void clickProfileIcon() {
		profileicon.click();
	}

	public void goToHomePage() {
		homepage.click();
	}

	public String getPremiumTag() {
		return premiumtag.getText();
	}

	public String getFreeTag() {
		return freetag.getText();
	}
	public WebElement checkBookmarkIcon() throws InterruptedException {
		return bookmarkicon.get(0);

	}
}
