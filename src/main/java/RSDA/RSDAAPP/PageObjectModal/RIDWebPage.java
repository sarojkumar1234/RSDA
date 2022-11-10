package RSDA.RSDAAPP.PageObjectModal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.android.AndroidDriver;

public class RIDWebPage extends AndroidAction {
	public AndroidDriver driver;


	@FindBy(xpath = "//button[contains(text(),'Sign in/Sign up')]")
	private WebElement signinsignupbutton;

	@FindBy(id = "user_id")
	private WebElement userName;

	@FindBy(id = "cta")
	private WebElement nextbutton;

	@FindBy(id = "password_current")
	private WebElement password;

	@FindBy(id = "prOu_88")
	private WebElement createnewaccountbutton;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//input[@name='']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@aria-label=\"Last name\"]")
	private WebElement lastname;

	@FindBy(xpath = "//div[@id='cta']/div")
	private WebElement registerbutton;

	@FindBy(xpath = "//input[@aria-label=\"Re-enter Email\"]")
	private WebElement reenteremail;

	@FindBy(xpath = "//input[@aria-label=\"Re-enter Password\"]")
	private WebElement reenterpassword;

	@FindBy(id = "prim_87")
	private WebElement completeregistration;

	@FindBy(xpath = "(//div[@tabindex=\"0\"])[4]")
	public WebElement signin;

	public RIDWebPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickLoginButton() {
		signinsignupbutton.click();
	}

	public void setUserName(String uname) {

		userName.sendKeys(uname);

	}

	public void clickNextButton() {
		nextbutton.click();
	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);

	}

	public void clickSignIn() {
		signin.click();
	}

	public void clickcreateNewAccountButton() {

		createnewaccountbutton.click();

	}

	public void setEmail(String Email) {
		email.sendKeys(Email);
	}

	public void reEnterEmail(String Email) {
		reenteremail.sendKeys(Email);
	}

	public void reEnterPassword(String text) {
		reenterpassword.sendKeys(text);
	}

	public void createPassword(String pwd) {
		Password.sendKeys(pwd);

	}

	public void setFirstName(String fname) {

		firstname.sendKeys(fname);
	}

	public void setLastName(String lname) {

		lastname.sendKeys(lname);
	}

	public void clickSignUp() {
		registerbutton.click();
	}

	public void clickCompleteSignUp() {
		completeregistration.click();
	}

}