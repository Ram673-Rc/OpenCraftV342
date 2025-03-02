package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegisterationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterTest extends BaseClass {
	

    @Test(groups = {"sanity","regression","master"})
    public void Account_registration() {
    	try {
        logger.info("**** Starting TC001 ****"); // Moved inside the test method

        HomePage hp = new HomePage(driver);
        hp.ClickMyAccount();
        logger.info("**** Clicked Account ****"); 
        hp.ClickRegister(); // Corrected method name
        logger.info("**** Clicked Register ****"); 

        AccountRegisterationPage ap = new AccountRegisterationPage(driver);
        logger.info("**** Providing customer details ****"); 
        ap.SetFirstName(randomString().toUpperCase());
        ap.SetLastName(randomString().toUpperCase());
        ap.SetEmail(randomString() + "@gmail.com");

        ap.SetTelePhone(randomNumber());

        String password = randomAlphaNumeric(); // Generates a valid password
        ap.SetPassword(password);
        ap.SetCofmPassword(password);

        ap.Privacyagree();
        ap.Continue();

        String conf = ap.ConfiramtionMsg(); // Corrected typo
        Assert.assertEquals(conf, "Your Account Has Been Created!");

       
     
        	
        }
    	catch(Exception e)
    	{
    		logger.error("Test failed");
    		//logger.debug("Debug logs");
    		Assert.fail();
        }
    	 logger.info("**** TC001 Completed Successfully ****"); // Log test completion
    }
}
