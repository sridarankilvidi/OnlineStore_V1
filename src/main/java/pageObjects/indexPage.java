package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.log;
import actionDriver.action;

public class indexPage extends baseClass{

	action action= new action();
	
	//By EMAIL = By.name("login[email]"); this is another way to find the locator
	// then you have to use findelement to get the webelement instance
	//getDriver().findelement(EMAIL);
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public indexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	// click the signin link and loginpage is displayed
	public loginPage clickOnSignIn() throws Throwable {
		loginPage lp = null ;
		
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		//return new loginPage();
		
		String acturl =getDriver().getCurrentUrl();		
		String expurl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		
		try {
			Assert.assertEquals(acturl,expurl);
			lp = new loginPage();
		}catch( AssertionError e) {
			log.error("Login page is not displayed - Error in URL!");
		}
		return lp;
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public String getMyStoreTitleNegative() {
		//String myStoreTitel=getDriver().getTitle();
		String wrongTitle = "Wrong Title";
		return wrongTitle;
	}
	
	public boolean validateLogoNegative() {
		return false;
	}
	// in indexpage, search function is available-so do some search tests
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
}
