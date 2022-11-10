package RSDA.RSDAAPP.PageObjectModal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SettingPage extends AndroidAction {
	public AndroidDriver driver;

	@FindBy(xpath = "//button[@data-testid=\"user-profile-header\"]")
	private WebElement profileicon;

	@FindBy(xpath = "//button[@class=\"btn-util label-emphasis-size-md items-center flex outlined\"]")
	private WebElement editbutton;

	@FindBy(xpath = "//button[contains(text(),'Sign out and edit on my Rakuten')]")
	private WebElement signoutandeditbutton;

	@FindBy(xpath = "//android.widget.TextView[@index='3']")
	private WebElement acceptpopup;

	@FindBy(xpath = "//android.widget.TextView[@index='2']")
	private WebElement rejectpopup;

	@FindBy(xpath = "//span[contains(text(),'Payment history')]")
	private WebElement paymentstatus;

	@FindBy(xpath = "//span[contains(text(),'Subscription status')]")
	private WebElement subscriptionstatus;

	@FindBy(xpath = "//span[contains(text(),'Personal information')]")
	private WebElement personalinformation;

	@FindBy(xpath = "//button[@class=\"ml-spacer-300 s-min:hidden absolute left-[5px]\"]")
	private WebElement sidebar;

	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	private WebElement setting;

	@FindBy(xpath = "//div[@class=\"ml-auto cursor-pointer relative top-[1px]\"]")
	private WebElement dropdown;

	public SettingPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProfileIcon() {
		profileicon.click();
	}

	public void clickSignOutAndEditButton() {
		signoutandeditbutton.click();
	}

	public void acceptPopUp() {
		acceptpopup.click();
	}

	public void clickPaymentStatus() {
		paymentstatus.click();
	}

	public void clickSubscriptionStatus() {
		subscriptionstatus.click();
	}

	public void clickPersonalInformation() {
		personalinformation.click();
	}

	public void clickEditOnMyRakuten() {
		editbutton.click();

	}

	public void clickSideBar() {
		sidebar.click();
	}

	public void clickSetting() {
		setting.click();
	}

	public void clickDropdown() {
		dropdown.click();
	}

}
