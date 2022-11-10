package RSDA.RSDAAPP.PageObjectModal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSDA.RSDAAPP.Utility.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MyProgressPage extends AndroidAction {
	public AndroidDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@text='Lessons completed']")
	public WebElement lessonscompleted;
	
	@FindBy(xpath = "//button[@class=\"ml-spacer-300 s-min:hidden absolute left-[5px]\"]")
	private WebElement sidebar;
	
	@FindBy(xpath="//span[contains(text(),'My Progress')]")
	private WebElement myprogress;

	@FindBy(xpath="//button[@class=\"btn-util label-emphasis-size-md items-center flex secondary-text\"]")
	private List<WebElement> channelcalculation;
	
	@FindBy(xpath="//span[@class=\"label-emphasis-size-xl\"]")
	private WebElement completedvideo;
	
	

	@FindBy(xpath="//button[@class=\" absolute right-spacer-200 top-0 z-10\"]")
	public List<WebElement> bookmarkicon;

	public MyProgressPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	


	public int sumofchannelVideos() {
		int sum=0;
		for(int i=0;i<channelcalculation.size();i++)
		{
			String text=channelcalculation.get(i).getText();
			int index = text.indexOf("/");
			   text = text.substring(0, index);
			   int no=Integer.parseInt(text);
			   sum=sum+no;
			 
		}return sum;
		
	}

	public int LessonsCompleted() {
		String text=text=completedvideo.getText();
		return Integer.parseInt(text);
		

	}
	public void clickSideBar()
	{
		 sidebar.click();
	}
	public void clickMyProgress() {
		myprogress.click();
	}

}
