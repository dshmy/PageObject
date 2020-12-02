package page;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class FiveElementCartPage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"cart-products__row cart-products__row_ga\"]")
    private List<WebElement> cartItems;
    @FindBy(xpath = "//button[@class=\"button small button-simple secondary\"]")
    private WebElement addOneMoreItemButton;
    public FiveElementCartPage(WebDriver driver){
        super(driver);
    }
    public FiveElementCartPage openCartPage()
    {
        driver.get("https://5element.by/cart");
        return this;
    }
    public int getCountOfItems(){
        return cartItems.size();
    }
    public FiveElementCartPage addOneMoreItem()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addOneMoreItemButton)).click();
        return this;
    }
    public float checkPhonePrice()
    {
        return new Float (new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class=\"cart-products__price\"]/span"))).getText().replaceAll("\\s+",""));
    }
}