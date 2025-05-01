package TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModule.HomePage;
import BaseClass.BASEClass;

public class TC_001_Verify_Logo extends BASEClass 
{
	
	@Test
	public void verifyLogo () 
	{
		logger.info("Logo Test is Start........");
		HomePage HM=new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(HM.getparaBank()));
		HM.isDisplayed();
		logger.debug(HM.isDisplayed());
		
	//	Assert.assertTrue(HM.isDisplayed(), "Verify Logo is not Displayed"+HM.isDisplayed());
	Assert.fail();
	}

}
