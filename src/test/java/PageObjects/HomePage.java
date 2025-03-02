package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    // Constructor created
    public HomePage(WebDriver driver) {
        super(driver);
    }	
    
    // Locators created
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement lnkLogin;

    // Action methods
    public void ClickMyAccount() {
        lnkMyAccount.click();
    }

    public void ClickRegister() {  // Fixed typo
        lnkRegister.click();
    }

    public void ClickLogin() {
        lnkLogin.click();
    }
}
