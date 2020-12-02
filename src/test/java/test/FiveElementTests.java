package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import page.FiveElementCartPage;
import page.FiveElementHomePage;

public class FiveElementTests {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void driverInitiate(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-popup-blocking");
        option.addArguments("--window-size=1600,900");
        driver = new ChromeDriver(option);
    }
    @Test
    public void addPhoneToCart() {
        int countOfPhones = new FiveElementHomePage(driver)
                .openPage()
                .inputPhoneName()
                .addInCart()
                .openCartPage()
                .getCountOfItems();

        Assert.assertEquals(countOfPhones, 1);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDownAfterAddPhoneToCart() {
        driver.quit();
    }
    @Test
    public void increaseNumberOfPhonesInCart() {
        float phonePriceBeforeIncrease= new FiveElementHomePage(driver)
                .openPage()
                .inputPhoneName()
                .addInCart()
                .openCartPage()
                .addOneMoreItem()
                .checkPhonePrice();
        driver.navigate().refresh();
        float phonePriceAfterIncrease = new FiveElementCartPage(driver)
                .checkPhonePrice();
        Assert.assertTrue(phonePriceAfterIncrease>phonePriceBeforeIncrease);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDownAfterCheckPhonesPriceInCart() {
        driver.quit();
    }
}
