package actionDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.baseClass;

public class action extends baseClass implements actionInterface{

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
	}

	@Override
	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
		
	}

	@Override
	public boolean type(WebElement ele, String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement locator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getColumncount(WebElement row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount(WebElement table) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Alert(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrentURL(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean click1(WebElement locator, String locatorName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		 Wait<WebDriver> wait = null;
		    try {
		        wait = new FluentWait<WebDriver>((WebDriver) driver)
		        		.withTimeout(Duration.ofSeconds(20))
		        	    .pollingEvery(Duration.ofSeconds(2))
		        	    .ignoring(Exception.class);
		        wait.until(ExpectedConditions.visibilityOf(element));
		        element.click();
		    }catch(Exception e) {
		    }
		
		
	}

	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		}
		

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
		//driver.manage().timeouts().e.implicitlyWait(Duration.ofSeconds(timeOut));
		
	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
		
	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8080/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
		//return destination;
	}

	@Override
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	

}
