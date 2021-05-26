package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.LoginPage;
import PageFactory.QuickViewPopup;
import PageFactory.ShoppingCartPage;
import PageFactory.VerifyApplicationUI;
import Utility.AppUtility;

public class Selenium_Test {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\PROJECTS\\IntelliJ_Java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		AppUtility AppUtil = new AppUtility(driver);
		LoginPage login = new LoginPage(driver);
		VerifyApplicationUI VerifyUI = new VerifyApplicationUI(driver);
		QuickViewPopup quickView = new QuickViewPopup(driver);
		ShoppingCartPage cart = new ShoppingCartPage(driver);

		driver.get("http://automationpractice.com/index.php");
		VerifyUI.VerifyUI();
		login.login("rpinbox@live.com", "testuser");
		AppUtil.clickNav_Home();

		// AppUtil.clickSubMenuBlouses();
		// AppUtil.clickNav_Home();
		// AppUtil.clickSubMenuTShirts();
		// AppUtil.clickNav_Home();
		// AppUtil.clickMenuTShirts();
		// AppUtil.clickSubMenuEveningDresses();

		quickView.SelectProduct1();

		cart.ConfirmOrder();
		// cart.navigateSummary();
		// cart.navigateAddresses();
		// cart.navigateShipping();
		// cart.navigatePaymentMethod();
		// cart.confirmPayment();

		AppUtil.clickNav_Home();

		login.clickSignOut();
		driver.quit();
	}
}
//http://automationpractice.com/index.php