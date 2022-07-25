package pomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class homePage extends utilClasses {
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement button ;
	
	@FindBy(xpath="(//img[@class='_396cs4 _3exPp9'])[1]")
	private WebElement Manu;
	
	@FindBy(xpath="//span[@class='_2I9KP_'])[1]")
	private WebElement ElectronicsModule;
	
	@FindBy(xpath="//a[@title='Mi']")
	private WebElement MILink;
	
	
	
	
	
	@FindBy(xpath="(//div[@class=\"_2kHMtA\"])[1]")
	private WebElement productList;
	
	
public homePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;

}
	public void closeLoginWindow() throws EncryptedDocumentException, IOException {
		try {
			WebElement element = explicitWait(driver, button);
		element.click();;
		}catch(Exception e) {}
	}
	
	public void clickOnElectronicIcon() {
		Manu.click();	
	}
	
	public void clickOnMILink() {
	
			WebElement ele = explicitWait(driver, ElectronicsModule);
			mouseAction(driver).moveToElement(ele).perform();;
			WebElement ele1 = explicitWait(driver, MILink);
			mouseAction(driver).moveToElement(ele1).click().build().perform();
			
		}
		
	
	
	
	
	
	
}





