package TestScripts;

import PageFactory.LoginPage;
import PageFactory.QuickViewPopup;
import PageFactory.ShoppingCartPage;
import PageFactory.VerifyApplicationUI;
import Utility.AppUtility;
import Utility.Utility;
import Utility.Json_Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Selenium_Test1 {
	WebDriver driver;
	LoginPage login;
	VerifyApplicationUI verifyUI;
	AppUtility appUtil;
	QuickViewPopup quickView;
	ShoppingCartPage cart;
	static Boolean reuseBrowser = false;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = Utility.getDriver(reuseBrowser);
		login = new LoginPage(driver);
		verifyUI = new VerifyApplicationUI(driver);

		appUtil = new AppUtility(driver);
		quickView = new QuickViewPopup(driver);
		cart = new ShoppingCartPage(driver);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void TS01_VerifyLogin() {
		verifyUI.VerifyUI();
		if (!login.verifyLoginStatus()) {
			login.login("rpinbox@live.com", "testuser");
			System.out.println(login.verifyLoginStatus());
		}
		appUtil.clickNav_Home();
	}

	@Test
	public void TS02_VerifyAddToCart_Option1() throws InterruptedException {
		// appUtil.clickSubMenuBlouses();
		// appUtil.clickNav_Home();
		// appUtil.clickSubMenuTShirts();
		// appUtil.clickNav_Home();
		appUtil.clickMenuTShirts();
		// appUtil.clickSubMenuEveningDresses();
		// appUtil.clickSubMenuSummerDresses();
		quickView.SelectProduct1();
		appUtil.clickNav_Home();
		System.out.println("Cart Quantity" + cart.getCartQuantity());
	}

	@Test
	public void TS03_VerifyAddToCart_Option2() throws InterruptedException {
		appUtil.clickSubMenuSummerDresses();
		quickView.SelectProduct2();
		appUtil.clickNav_Home();
	}

	@Test
	public void TS04_VerifyAddToCart_Option3() throws InterruptedException {
		appUtil.clickSubMenuSummerDresses();
		quickView.SelectProduct3();
		appUtil.clickNav_Home();
	}

	@Test
	public void TS05_VerifyPlacingOrder() {
		appUtil.clickCartWidget();
		cart.ConfirmOrder();
		appUtil.clickNav_Home();
	}

	@Test
	public void TS06_VerifyLogout() {
		login.clickSignOut();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		Json_Utility.deleteJsonFile();
	}
}
