package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiveElementHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://5element.by";
    private static String phoneName = "Смартфон Huawei Y9s (STK-L21) светло-голубой";
    @FindBy(xpath = "//div[@class=\"searchbox js-search-main\"]")
    private WebElement searchStringClick;
    @FindBy(xpath = "//*[@id='q']")
    private WebElement searchInputString;
    @FindBy(xpath = "//a[@href=\"/products/652963-smartfon-huawei-y9s-stk-l21-svetlo-goluboy?q=смартфон huawei y9s (stk-l21) светло-голубой\"]")
    private WebElement pickPhone;
    public FiveElementHomePage(WebDriver driver){
        super(driver);
    }
    public FiveElementHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public FiveElementItemPage inputPhoneName(){
        searchStringClick.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(searchInputString)).sendKeys(phoneName);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(pickPhone)).click();
        return new FiveElementItemPage(driver);
    }
}
