package testCasess;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import BaseClasses.Drivers;
import pomClasses.CartPage;
import pomClasses.LinkPage;

import pomClasses.ProductDetails;
import pomClasses.homePage;



public class VerifyUserCanBuyProduct {
	
	WebDriver driver;
	homePage hp;
	LinkPage lp ;
	ProductDetails pd;
	CartPage cp ;
	ExtentHtmlReporter htmlReporter;
	com.aventstack.extentreports.ExtentReports report;
	com.aventstack.extentreports.ExtentTest test;
	
	@BeforeClass
	public  void beforeClass() {
		htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("VerifyUserCanBuyProduct");
		driver= Drivers.getDriver("edge");
		
		
		
	}

	
	@BeforeMethod
	public void  beforeMethod() {
		hp = new homePage(driver);
		lp = new LinkPage(driver);
		pd = new ProductDetails(driver);
		cp = new CartPage(driver);
	}
	
  @Test
public void closeLoginScreen() throws EncryptedDocumentException, IOException{
	 hp.closeLoginWindow();
	  
	
	 
	  }
  
  @Test(priority=1)
public void verifyUserInMiLink()   {
	 
	hp.clickOnElectronicIcon();
	hp.clickOnMILink();
	
	  Assert.assertTrue(lp.isOnMIPage());
  }

 @Test(priority=2)
 public void SelectByPriceSlider() {
	 lp.priceSlider();
	 
 }
 @Test(priority=3) 
 public void SelectByPriceDropDown() {
	 lp.priceDropDown();
 }
 @Test(priority=4)
 public void SelectFirstProduct() {
	 lp.enterSearchData();
	 lp.clickOnProduct();
 }
 @Test(priority=5)
 public void SwitchToProduct() {
	 pd.switchProductPage();
 }
@Test (priority=6)
public void verifyProductPrice() {
	Assert.assertTrue(pd.compareProductPrice());
}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+"Test is passed");
		}else {
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, result.getName()+"Test is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	@AfterClass
	public void afterClass() {
		report.flush();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
