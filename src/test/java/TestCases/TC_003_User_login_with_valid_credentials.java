package TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BASEClass;
import PageObjectModule.HomePage;

public class TC_003_User_login_with_valid_credentials extends BASEClass {

	@Test(groups = { "sanity", "master" })
	public void User_login_with_valid_credentials() {

		HomePage H = new HomePage(driver);

		wait.until(ExpectedConditions.visibilityOf(H.getusername()));
		H.sendusername(p.getProperty("Username") + getRandomString());

		wait.until(ExpectedConditions.visibilityOf(H.getpassword()));
		H.sendpassword(p.getProperty("Password"));

		wait.until(ExpectedConditions.visibilityOf(H.getlogIn()));
		H.clickOnlogIn();

		// MyAccountPage
		PageObjectModule.MyAccountPage MA = new PageObjectModule.MyAccountPage(driver);
		wait.until(ExpectedConditions.visibilityOf(MA.getlogOut()));

		Assert.assertTrue(MA.isDisablelogOut(),
				"TC_003_User_login_with_valid_credentials is failed" + MA.isDisablelogOut());

	}

}