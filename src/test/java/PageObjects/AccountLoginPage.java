package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {

    public AccountLoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators created
    @FindBy(xpath = "//input[@placeholder='E-Mail Address']")
    WebElement txtEmailadd;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement clksumbit;

    public void SetEmailid(String email) {
        txtEmailadd.sendKeys(email);
    }

    public void SetPassword(String Pass) {
        txtPassword.sendKeys(Pass);
    }

    public void Clicklogin() {
        clksumbit.click();
    }
}
