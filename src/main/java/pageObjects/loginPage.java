package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.action;

public class loginPage extends baseClass{
	
	action action= new action();
	
	@FindBy(xpath = "//a[@class='logout']") 
	private WebElement signOut;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	

}
