package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickViewPopup {
	WebDriver driver;
	Actions actions;

	// Product Elements
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]")
	private WebElement Product01;
	@FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]")
	private WebElement Product02;
	@FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]")
	private WebElement Product03;
	@FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[1]/div/a[2]/span")
	private WebElement QuickView;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]")
	private WebElement QuickAddToCart2;
	@FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[2]")
	private WebElement QuickMore3;

	// QuickView Elements
	@FindBy(id = "product")
	private WebElement ProductView;
	// Thumbnail
	// @FindBy(id = "thumb_1")
	// private WebElement ThumbNail1;
	// @FindBy(id = "thumb_2")
	// private WebElement ThumbNail2;

	@FindBy(id = "quantity_wanted")
	private WebElement Quantity;
	@FindBy(id = "group_1")
	private WebElement SizeGroup;
	@FindBy(id = "add_to_cart")
	private WebElement AddToCart;

	@FindBy(xpath = "//span[contains(title(),'Continue shopping')]")
	private WebElement ContinueShopping;
	@FindBy(xpath = "//div[@id='layer_cart']/div[1]/div[2]/div[4]/a[1]")
	private WebElement ProceedToCheckout;

	@FindBy(name = "Submit")
	private WebElement ProductAddToCart;

	public QuickViewPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void SelectProduct1() throws InterruptedException {
		Product01.isEnabled();
		actions.moveToElement(Product01, 5, 0).perform();
		QuickView.click();
		System.out.println("Product - Clicked");
		QuickViewActions();
	}

	private void QuickViewActions() throws InterruptedException {
		driver.switchTo().frame(0);
		if (ProductView.isDisplayed()) {
			System.out.println("Product quick view - Displayed");
		}
		Quantity.clear();
		Quantity.sendKeys("2");
		// SizeGroup.isDisplayed();
		AddToCart.click();
		System.out.println("QuickViewActions - Items added to cart");
		Thread.sleep(10000);
		// ContinueShopping.isDisplayed();
		ProceedToCheckout.click();
		Thread.sleep(2000);
	}

	public void SelectProduct2() throws InterruptedException {
		actions.moveToElement(Product02, 5, 0).perform();
		QuickAddToCart2.click();
		ProceedToCheckout.click();
		System.out.println("Product Added via Quick Option");
	}

	public void SelectProduct3() throws InterruptedException {
		actions.moveToElement(Product03, 5, 0).perform();
		QuickMore3.click();
		ProductAddToCart.click();
		ProceedToCheckout.click();
		Thread.sleep(2000);
		System.out.println("Product Added via Product Page Option");
	}
}