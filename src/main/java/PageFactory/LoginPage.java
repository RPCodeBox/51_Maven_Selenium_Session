package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// WebDriver driver;

	@FindBy(linkText = "Sign in")
	private WebElement SignIn;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement passwd;

	@FindBy(linkText = "Forgot your password?")
	private WebElement ForgotPassword;

	@FindBy(id = "SubmitLogin")
	private WebElement Submit;

	@FindBy(linkText = "Sign out")
	private WebElement SignOut;

	@FindBy(xpath = "//div[@class='header_user_info']")
	private WebElement LoginStatus;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Authentication')]")
	private WebElement AuthenticationBar;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'My account')]")
	private WebElement MyAccountBar;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void SignInClick() {
		SignIn.click();
		if (AuthenticationBar.isDisplayed() && ForgotPassword.isDisplayed()) {
			System.out.println("LoginPage: AuthenticationBar and Forgot Password - Displayed");
		}
		if (ForgotPassword.isDisplayed()) {
			System.out.println("LoginPage: Forgot Password - Link displayed");
		}
	}

	public void setEmailId(String strUserName) {
		SignIn.click();
		email.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		passwd.sendKeys(strPassword);
	}

	public void clickLogin() {
		Submit.click();
	}

	public void login(String strUserName, String strPassword) {
		SignInClick();
		setEmailId(strUserName);
		setPassword(strPassword);
		clickLogin();
		if (MyAccountBar.isDisplayed() && SignOut.isDisplayed()) {
			System.out.println("LoginPage> Sign in - Successful");
		}
	}

	public void clickSignOut() {
		SignOut.click();
		if (SignIn.isDisplayed()) {
			System.out.println("LoginPage> Sign out is done");
		}
	}

	public boolean verifyLoginStatus() {
		if (LoginStatus.getText().contains("Sign in")) {
			return false;
		} else {
			System.out.println("LoginPage> Logged as: " + LoginStatus.getText());
			return true;
		}
	}
}