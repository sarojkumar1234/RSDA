package RSDA.RSDAAPP.PageObjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class IniestaTVPage extends AndroidAction {
	public AndroidDriver driver;

	@FindBy(xpath = "//android.view.View[@index='0']")
	private WebElement playvideo;

	@FindBy(xpath = "//button[@class=\"ml-spacer-300 s-min:hidden absolute left-[5px]\"]")
	private WebElement sidebar;

	@FindBy(xpath = "//span[contains(text(),'Iniesta TV')]")
	private WebElement iniestatv;

	@FindBy(xpath = "//button[@data-testid=\"user-profile-header\"]")
	private WebElement profileicon;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement homepage;

	@FindBy(xpath = "//span[contains(text(),'Premium')]")
	private WebElement premiumtag;

	@FindBy(className = "headline-size-sm")
	private WebElement authwalltext;

	@FindBy(xpath = "//p[contains(text(),'All about Iniesta')]")
	private WebElement iniestatvdescription;

	public IniestaTVPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void playIniestaVideo() {
		playvideo.click();
	}

	public String getIniestaTVDescription() {
		return iniestatvdescription.getText();
	}

	public WebElement isAuthWallTextDisplayed() {
		return authwalltext;
	}

	public void clickSideBar() {
		sidebar.click();
	}

	public void clickIniestaTv() {
		iniestatv.click();
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

}
