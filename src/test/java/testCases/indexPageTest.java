package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.log;
import pageObjects.indexPage;
import pageObjects.loginPage;
import pageObjects.SearchResultPage;
import pageObjects.baseClass;

public class indexPageTest extends baseClass {

private indexPage indexPage;
private loginPage lp; 
private SearchResultPage sp;

	@Parameters("browser")
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
		log.info("The thread that is running is :" + Thread.currentThread().getId());
	}
	
	@AfterTest(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=0,groups = "Smoke")
	public void verifyLogo() throws Throwable {
		log.startTestCase("verifyLogo");
		indexPage= new indexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		log.endTestCase("verifyLogo");
	}
	
	@Test(priority=1, groups = "Smoke")
	public void verifyTitle() {
		log.startTestCase("verifyTitle");
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		log.endTestCase("verifyTitle");
	}
	
	@Test(priority=2, groups = "Smoke")
	public void clickOnSignInTest() throws Throwable {
		log.startTestCase("clickOnSignInTest");
		lp = indexPage.clickOnSignIn();
		Assert.assertNotNull(lp);
		log.endTestCase("clickOnSignInTest");
	}
	
	@Test(priority=3, groups = "Smoke", enabled=false)
	public void searchProductTest(String prodname) throws Throwable {
		log.startTestCase("searchProductTest");
		sp = indexPage.searchProduct(prodname);
		Assert.assertNotNull(sp);
		log.endTestCase("searchProductTest");
	}
}
