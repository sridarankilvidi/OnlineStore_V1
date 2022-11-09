package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.log;
import pageObjects.baseClass;
import pageObjects.homePage;
import pageObjects.indexPage;
import pageObjects.loginPage;

public class loginPageTest extends baseClass{
	private indexPage ip;
	private loginPage lp;
	private homePage hp;
	
	@Parameters("browser")
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser); 
		log.info("The thread that is running is :" + Thread.currentThread().getId());
		log.startTestCase("Setting up he environment to perform the login test");
		ip= new indexPage();
		boolean result=ip.validateLogo();
		Assert.assertTrue(result);
		//log.endTestCase("verifyLogo successful");
		lp = ip.clickOnSignIn();
		Assert.assertNotNull(lp,"Loginpage is not displayed...something went wrong!!");
	}	

	@AfterTest(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=0,groups= {"Smoke"},description="This method tests valid login credentials", enabled=true)
	public void doLoginTest() throws InterruptedException {
		hp = lp.doLogin();
		Assert.assertNotNull(hp,"Homepage is not displayed after login...something went wrong!!");
		hp.doSignOut();
	}
	
	@Test(priority=1,groups= {"Smoke"},description="This method tests logout is successful", enabled=true)
	public void doLogoutTest() throws InterruptedException {
		boolean flag = false;
		flag = hp.doSignOut();
		Assert.assertTrue(flag, "Logout has failed!");
	}
	
	@Test(priority=2,groups= {"Smoke"},description="This method tests valid login credentials")
	public void doLoginTestNegative() throws InterruptedException {
		hp = lp.doLoginNegative();
		Assert.assertNotNull(hp,"Homepage is not displayed after login...something went wrong!!");
	}
	
	

}
