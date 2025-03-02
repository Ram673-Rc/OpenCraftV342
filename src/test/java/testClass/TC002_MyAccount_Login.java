package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountLoginPage;
import PageObjects.HomePage;
import PageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC002_MyAccount_Login extends BaseClass {
public WebDriver driver;

    @BeforeClass(groups = {"sanity","regression","master"})
    public void setup() {
        // Initialize WebDriver (you can also use WebDriverManager here)
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Test(groups = {"sanity","regression","master"})
    public void Verify_login() {
    	logger.info("***** TC002 execution started *****");
        try {
            // HomePage actions
            HomePage a = new HomePage(driver);
            a.ClickMyAccount();
            a.ClickLogin();

            // Account Login Page actions
            AccountLoginPage ac = new AccountLoginPage(driver);
            Thread.sleep(1000);
          
            ac.SetPassword(p.getProperty("Password"));
            ac.SetEmailid(p.getProperty("email"));
            ac.Clicklogin();

            // My Account page actions
            MyaccountPage mac = new MyaccountPage(driver);
            boolean tar = mac.isMyAccountPageExists();
            Assert.assertTrue(tar, "Login failed");

        } catch (Exception e) {
            
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
        logger.info("***** TC002 succefully completed *****");
    }
   
}
