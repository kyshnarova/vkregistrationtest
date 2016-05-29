import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ky on 30.04.2016.
 */

public class VkTest {
    static WebDriver driver;
    private String url = "http://vk.com";
    private String email = "test@gmail.com";
    private String password = "123";
    By myProfileButton = By.xpath(".//button[@id='myprofile']");

    @BeforeMethod
    public void tearUp(){
        driver = new FirefoxDriver(); //тип класса = тип объекта
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage(driver);
        homePage.open(url)
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitButton();
        Assert.assertTrue(isElementPresent(myProfileButton),"MyProfile button is not present");
    }

    @Test(enabled = false)
    public void loginTest2(){
        HomePage homePage = new HomePage(driver);
        homePage.open(url)
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitButton();
        Assert.assertFalse(isElementPresent(myProfileButton),"MyProfile button is not present");
    }

    private static boolean isElementPresent (By locator){
        return driver.findElements(locator).size() !=0;
    }

}
