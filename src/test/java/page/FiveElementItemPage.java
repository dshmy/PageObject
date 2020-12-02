package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiveElementItemPage extends AbstractPage {
    @FindBy(xpath = "//button[@class=\"spec-product-right-button button js-to-cart\"]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class=\"button js-modal__footer-cell js-goto-cart\"]")
    private WebElement goToCartButton;
    public FiveElementItemPage(WebDriver driver){
        super(driver);
    }
    public FiveElementCartPage addInCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        return new FiveElementCartPage(driver);
    }
}
