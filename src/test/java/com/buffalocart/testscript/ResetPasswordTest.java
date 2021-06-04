package com.buffalocart.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;

public class ResetPasswordTest extends Base {
	LoginPage login;
	ResetPasswordPage reset;
	@Test(enabled=true)
	public void verifyErrorMessage()
	{
		login=new LoginPage(driver);
		reset=login.clickResetPassword();
		reset.enterEmailForRecovery("juju@gmail.com");
		reset.clickSubmitEmail();
		String actualresult=reset.getTextOfErrorMessage();
		String expectedresult="We can't find a user with that e-mail address.";
		Assert.assertEquals(actualresult, expectedresult,"Wrong");
	}
	

}
