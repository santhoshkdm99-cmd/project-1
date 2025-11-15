import org.apache.commons.math3.util.OpenIntToFieldHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Ecom {
    WebDriver driver = new ChromeDriver();

    @Test
    public void login()  {
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@formcontrolname='userEmail']")).sendKeys("hardikmohan3300@gmail.com");
        driver.findElement(By.xpath("//input[@formcontrolname='userPassword']")).sendKeys("1234567Sk.");
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }
    @Test
    public void add_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space()='ADIDAS ORIGINAL']/ancestor::div[contains(@class,'card-body')]//button[contains(.,'Add To Cart')]")));
        button.click();

    }
}