package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class LinkPage extends utilClasses{
	WebDriver driver;
	@FindBy(xpath="//h1[@class='_10Ermr']")
	private WebElement MItest;
	@FindBy(xpath="//div[@class='_31Kbhn WC_zGJ']")
	private WebElement drag;
	@FindBy (xpath="//div[@style='transform: translateX(-44.2464px);']")
	private WebElement drop;
	@FindBy (xpath ="//select[@class='_2YxCDZ']")
	WebElement dropDown;
	
	@FindBy (xpath ="//input[@type='text']")
	WebElement SearchBar;
	@FindBy (xpath ="//Button[@type='submit']")
	WebElement submit;
	@FindBy(xpath ="//div[@class='_4rR01T']")
	WebElement product;
	
	public LinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public boolean isOnMIPage() {
		if(MItest.getText().equalsIgnoreCase("Mi Mobiles"))
		return true;
		else
		return false;
	}
	
	public void priceSlider() {
		mouseAction(driver).dragAndDrop(drag, drop);
	
		
	}
	
	public void priceDropDown() {
		selectDropDown(dropDown, 9);
	}
	
	public void enterSearchData() {
		SearchBar.sendKeys("Redmi go (Black, 8gb)");
		submit.click();
	}
	public void clickOnProduct() {
		explicitWait(driver, product).click();
	
		
	}

}
