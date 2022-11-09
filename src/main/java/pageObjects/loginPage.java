package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.log;
import actionDriver.action;

public class loginPage extends baseClass{
	
	action action= new action();
	
	@FindBy(xpath = "//a[@class='logout']") 
	private WebElement signOut;
	
	@FindBy(css="#email")
	private WebElement email;
	
	@FindBy(css="#passwd")
	private WebElement password;
	
	//button[@id='SubmitLogin']
	@FindBy(xpath = "//button[@id='SubmitLogin']") 
	private WebElement loginBtn;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getLoginPageURL() {		
		String acturl = getDriver().getCurrentUrl();
		return acturl;		
	}
	
	public String getLoginPageTitle() {		
		String actTitle = getDriver().getTitle();
		return actTitle;		
	}
	
	public homePage doLogin() throws InterruptedException {
		homePage hp = null;
		if (action.isDisplayed(getDriver(), email)) {
			action.type(email,prop.getProperty("username"));
			action.type(password,prop.getProperty("password"));
			action.JSClick(getDriver(), loginBtn);
			Thread.sleep(2000);
			String acturl = getDriver().getCurrentUrl();
			String expurl = "http://automationpractice.com/index.php?controller=my-account";
			try {
				Assert.assertEquals(acturl,expurl);
				hp=new homePage();
			}catch( AssertionError e) {
				log.error("Home page is not displayed - Login is not successful!");
			}
		}		
		return hp;
	}
	
	public homePage doLoginNegative() throws InterruptedException {
		homePage hp2 = null;
		if (action.isDisplayed(getDriver(), email)) {
			action.type(email,"username");
			action.type(password,"password");
			action.JSClick(getDriver(), loginBtn);
			Thread.sleep(2000);
			String acturl = getDriver().getCurrentUrl();
			String expurl = "http://automationpractice.com/index.php?controller=my-account";
			try {
				Assert.assertEquals(acturl,expurl);
				hp2=new homePage();
			}catch( AssertionError e) {
				log.error("Home page is not displayed - Login is not successful!");
			}
		}		
		return hp2;
	}
}
