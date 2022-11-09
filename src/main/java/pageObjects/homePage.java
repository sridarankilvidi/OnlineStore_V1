package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.log;
import actionDriver.action;

public class homePage extends baseClass{
	
	action action= new action();
	
	@FindBy(xpath = "//a[@title='Log me out']") 
	private WebElement signOut;
	
	public homePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean doSignOut() throws InterruptedException {
		boolean flag = false;
		if (action.isDisplayed(getDriver(), signOut)) {
			log.info("logging out of home page ");
			signOut.click();
		}
		Thread.sleep(2000);
		/*
		 * String acturl = getDriver().getCurrentUrl();
		 * log.info("after sign-out of home page, the actual url is: " + acturl);
		 * System.out.println("The actual usl after logout is: "+ acturl); String expurl
		 * = "http://automationpractice.com/index.php?controller=my-account";
		 */
		
		String actTitle = getDriver().getTitle();
		log.info("after sign-out of home page, the actual title is: " + actTitle);
		String expTitle = "Login - My Store";
		try {
			Assert.assertEquals(actTitle,expTitle);
			flag=true;
			//loginPage lp = new loginPage();
		}catch( AssertionError e) {
			log.error("Home page is not displayed - Logout is not successful!");
		}
		return flag;
	}

}
