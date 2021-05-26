package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Your shopping cart')]")
	private WebElement NavShoppingCart;
	@FindBy(linkText = "Proceed to checkout")
	private WebElement ProceedToCheckout1;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Addresses')]")
	private WebElement NavAddresses;
	@FindBy(name = "processAddress")
	private WebElement ProceedToCheckout2;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Shipping')]")
	private WebElement NavShipping;
	@FindBy(name = "processCarrier")
	private WebElement ProceedToCheckout3;

	@FindBy(xpath = "//*[@id='cgv']")
	private WebElement TandC;

	@FindBy(xpath = "//span[contains(title(),'Continue shopping')]")
	private WebElement ContinueShopping;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Your payment method')]")
	private WebElement NavPaymentMethod;

	@FindBy(xpath = "//a[contains(@class,'bankwire')][contains(text(),'Pay by bank wire')]")
	private WebElement PayByBankWire;

	@FindBy(xpath = "//a[contains(@class,'cheque')][contains(text(),'Pay by check')]")
	private WebElement PayByCheck;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Check payment')]")
	private WebElement NavCheckPayment;

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	private WebElement ConfirmMyOrder;

	@FindBy(xpath = "//span[contains(@class,'navigation_page')][contains(text(),'Order confirmation')]")
	private WebElement NavOrderConfirmation;

	@FindBy(xpath = "//a[contains(text(),'Back to orders')]")
	private WebElement BackToMyOrder;

	@FindBy(className = "ajax_cart_quantity")
	private WebElement CartQuantity;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateSummary() {
		if (NavShoppingCart.isDisplayed()) {
			ProceedToCheckout1.click();
			System.out.println("Summary Tab, ProceedToCheckout - Clicked");
		}
	}

	public String getCartQuantity() {
		return CartQuantity.getText();
	}

	public void navigateAddresses() {
		if (NavAddresses.isDisplayed()) {
			ProceedToCheckout2.click();
			System.out.println("Addresses Tab, ProceedToCheckout - Clicked");
		}
	}

	public void navigateShipping() {
		if (NavShipping.isDisplayed()) {
			TandC.click();
			ProceedToCheckout3.click();
			System.out.println("Shipping Tab, ProceedToCheckout - Clicked");
		}
	}

	public void navigatePaymentMethod() {
		if (NavPaymentMethod.isDisplayed()) {
			// PayByBankWire.isDisplayed();
			PayByCheck.click();
			System.out.println("Payment Tab, ProceedToCheckout - Clicked");
		}
	}

	public void confirmPayment() {
		if (NavCheckPayment.isDisplayed()) {
			ConfirmMyOrder.click();
			System.out.println("Payment Tab, ConfirmMyOrder - Clicked");
		}
		if (NavOrderConfirmation.isDisplayed() && BackToMyOrder.isDisplayed()) {
			System.out.println("Payment Tab, Order confirmed");
			// Screen shot
		}
	}

	public void ConfirmOrder() {
		navigateSummary();
		navigateAddresses();
		navigateShipping();
		navigatePaymentMethod();
		confirmPayment();
	}
}