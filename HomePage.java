import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Ky on 30.04.2016.
 */
public class HomePage {
    WebDriver driver;
    //Locators
    By emailInputLocator = By.xpath(".//input[@id='quick_email']");
    By passInputLocator = By.xpath(".//input[@id='quick_pass']");
    By submitButtonLocator = By.xpath(".//button[@id='quick_login_button']");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage open(String url){
        driver.get(url);

        return this;
    }

    public HomePage enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.clear();
        emailInput.sendKeys(email);

        return this;
    }

    public HomePage enterPassword(String password){
        WebElement passInput = driver.findElement(passInputLocator);
        passInput.clear();
        passInput.sendKeys(password);

        return this;
    }

    public HomePage clickSubmitButton(){
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();

        return this;
    }
}
