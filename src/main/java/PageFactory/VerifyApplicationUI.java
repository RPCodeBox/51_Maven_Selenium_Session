package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyApplicationUI {
    WebDriver driver;

    @FindBy(id="search_query_top")
    private WebElement SearchText;

    @FindBy(linkText = "Contact us")
    private WebElement ContactUs;

    @FindBy(id="newsletter-input")
    private WebElement Newsletter;

    @FindBy(linkText = "support@seleniumframework.com")
    private WebElement SupportEmail;

    public VerifyApplicationUI(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void VerifyUI(){
        if(SearchText.isDisplayed()){
            System.out.println("VerifyApplicationUI> SearchText - Displayed");
        }
        if(ContactUs.isDisplayed()){
            System.out.println("VerifyApplicationUI> Contact Us - Link displayed");
        }
        if(Newsletter.isDisplayed()){
            System.out.println("VerifyApplicationUI> Newsletter - Displayed");
        }
        if(SupportEmail.isDisplayed()){
            System.out.println("VerifyApplicationUI> SupportEmail - Link displayed");
        }
    }
}