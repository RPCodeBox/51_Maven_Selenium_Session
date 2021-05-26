package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import PageFactory.ShoppingCartPage;

public class AppUtility {
	WebDriver driver;
	Actions actions;

	@FindBy(xpath = "//a[contains(@class,'sf-with-ul')][contains(text(),'Women')]")
	private WebElement MenuWomen;

	@FindBy(linkText = "Blouses")
	private WebElement SubMenuBlouses;

	@FindBy(linkText = "T-shirts")
	private WebElement SubMenuTShirts;

	// @FindBy(xpath =
	// "//a[contains(@class,'sf-with-ul')][contains(title(),'Dresses')]")
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement MenuDresses;
	// *[@id="block_top_menu"]/ul/li[2]/a

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")
	private WebElement SubMenuCasualDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a")
	private WebElement SubMenuEveningDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")
	private WebElement SubMenuSummerDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement MenuTShirts;

	@FindBy(linkText = "T-shirts")
	private WebElement MenuTshirts;

	@FindBy(xpath = "//a[contains(@class,'home')]")
	private WebElement Nav_Home;

	@FindBy(xpath = "//a[@title='View my shopping cart']/b[1]")
	private WebElement CartWidget;

	@FindBy(id = "button_order_cart")
	private WebElement CartWidgetCheckOut;

	public AppUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void clickMenuWomen() {
		actions.moveToElement(MenuWomen, 5, 0).perform();
		System.out.println("MenuWomenlicked");
	}

	public void clickSubMenuBlouses() {
		actions.moveToElement(MenuWomen, 5, 0).perform();
		actions.moveToElement(SubMenuBlouses).perform();
		SubMenuBlouses.click();
		System.out.println("SubMenuBlouses Menu Clicked");
	}

	public void clickSubMenuTShirts() {
		actions.moveToElement(MenuWomen, 5, 0).perform();
		actions.moveToElement(SubMenuTShirts).perform();
		SubMenuTShirts.click();
		System.out.println("SubMenuTShirts Clicked");
	}

	public void clickSubMenuCasualDresses() {
		actions.moveToElement(MenuDresses).perform();
		actions.moveToElement(SubMenuCasualDresses).perform();
		SubMenuCasualDresses.click();
		System.out.println("SubMenuCasualDresses Clicked");
	}

	public void clickSubMenuEveningDresses() {
		actions.moveToElement(MenuDresses).perform();
		actions.moveToElement(SubMenuEveningDresses).perform();
		SubMenuEveningDresses.click();
		System.out.println("SubMenuEveningDresses Clicked");
	}

	public void clickSubMenuSummerDresses() {
		actions.moveToElement(MenuDresses).perform();
		actions.moveToElement(SubMenuSummerDresses).perform();
		SubMenuSummerDresses.click();
		System.out.println("SubMenuSummerDresses Clicked");
	}

	public void clickMenuTShirts() {
		actions.moveToElement(MenuTShirts).perform();
		MenuTShirts.click();
		System.out.println("MenuTShirts Clicked");
	}

	public void clickNav_Home() {
		Nav_Home.click();
		System.out.println("AppUtility - Navigate Home Clicked");
	}

	public void clickCartWidget() {
		actions.moveToElement(CartWidget, 2, 0).perform();
		CartWidgetCheckOut.click();
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		System.out.println("CartWidget: Checkout clicked with Product quantity: " + cart.getCartQuantity());
	}
}