import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ky on 30.04.2016.
 */
public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new FirefoxDriver(); //тип класса = тип объекта

        // implicitly - дефолтное ожидание нахождения (поиска) элемента на веб-странице
        // explicitly -ожидаение какого-то действия (кнопка активная становится, должен произойти какой-то экшен на странице)
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //по дефолту 0 секунд
        driver.manage().window().maximize(); //отрыть браузер по максимуму (на весь экран)

        driver.get("http://vk.com");

        //узаваем с помощью чего мы будем искать элемент на веб-странице (css xpath!)
        By emailInputLocator = By.xpath(".//input[@id='quick_email']");
        By passInputLocator = By.xpath(".//input[@id='quick_pass']");
        By submitButtonLocator = By.xpath(".//button[@id='quick_login_button']");
        By myProfileButton = By.xpath(".//button[@id='myprofile']");

        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.clear(); //очишаем дефолтные значения
        emailInput.sendKeys("test23@gmail.com");

        WebElement passInput = driver.findElement(passInputLocator);
        passInput.clear();
        passInput.sendKeys("123");

        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();

        if (isElementPresent(myProfileButton)){
            System.out.println("Sunny");
        }
        else {
            System.out.println("Sad cloud. MyProfile button is not present");
        }

        driver.quit(); //закрывает полностью браузер со всеми окнами

        //driver.close(); //закрывает текущее окно
    }

    private static boolean isElementPresent (By locator){
        return driver.findElements(locator).size() !=0;
    }
}
