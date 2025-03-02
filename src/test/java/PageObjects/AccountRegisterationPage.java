package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {
	
	//Constructor created

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators created steps:
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement txtFistName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement txtTelePhone;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassWord;
	
	@FindBy(xpath="//input[@placeholder='Password Confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//label[text()='Yes']")
	WebElement btnClick;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement getConfiramtionMsg;
	
	public void SetFirstName(String fname) {
		txtFistName.sendKeys(fname);
	}
	public void SetLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void SetEmail(String Email) {
		txtEmail.sendKeys(Email);
		
	}
	public void SetTelePhone(String tel) {
		txtTelePhone.sendKeys(tel);
	}
	public void SetPassword(String Pw) {
		txtPassWord.sendKeys(Pw);
	}
	public void SetCofmPassword(String ConfPw) {
		txtConfirmPassword.sendKeys(ConfPw);
	}
	public void Click() {
		btnClick.click();
	}
	public void Privacyagree() {
		btnAgree.click();
	}
	public void Continue() {
		btnContinue.click();
	}
	
	public String ConfiramtionMsg() {
		try {
			return(getConfiramtionMsg.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}

}
