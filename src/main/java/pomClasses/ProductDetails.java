package pomClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class ProductDetails extends utilClasses {
	WebDriver driver;
	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement buyNowButton;
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCardButton;
	@FindBy(xpath= "//span[@class='B_NuCI']")
	private WebElement ProductDetails;
	@FindBy(xpath ="//div[@class='_30jeq3 _16Jk6d']")
	private WebElement price;

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

 public void switchProductPage() {
	 List<String> list = new ArrayList<String>(driver.getWindowHandles());
	 
	 driver.switchTo().window(list.get(1));

 }
 public Boolean compareProductPrice() {
	String a = explicitWait(driver, price).getText().trim();
	a= a.replaceAll("[^\\d]", "");
	a=a.trim();
    a=a.replaceAll(" ", "");
	int b = Integer.parseInt(a);
	 if(b>0) {
		  return true;
	 }
	 else {
		 return false;
	 }

 }


	
	
}
	

