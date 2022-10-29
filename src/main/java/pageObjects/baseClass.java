package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utility.extentManager;
import Utility.log;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		extentManager.setExtent();
		DOMConfigurator.configure(".//Configuration/log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(".//Configuration/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());//InternetExplorerDriver()
		}
		log.info("============="+browserName +"browser initiated=========");
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit & pageload timeouts
		int pagetime = Integer.parseInt(prop.getProperty("pageLoadTimeOut"));
		int imptime = Integer.parseInt(prop.getProperty("implicitWait"));
		
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pagetime));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(imptime));
		
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}
	

	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		extentManager.endReport();
	}
}
