package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    // protected abstract AbstractPage openPage();
    protected static final int WAIT_TIMEOUT_SECONDS = 50;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}