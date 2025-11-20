package Ecom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Name;
import java.time.Duration;
import java.util.List;

public class Ecom {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Given("I open the e-commerce login page")
    public void Home_page() {
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
    }

    @When("I enter username(.+) and password (.+)$")
    public void login(String email, String password) {
        driver.findElement(By.xpath("//input[@formcontrolname='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@formcontrolname='userPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }

    @And("I add the product ADIDAS ORIGINAL to the cart")
    public void add_to_cart() throws InterruptedException {

        for (int i = 0; i < 15; i++) {
            try {
                driver.findElement(By.xpath("//b[text()='ADIDAS ORIGINAL']"));
                break;
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
                Thread.sleep(300);
            }
        }
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//b[text()='ADIDAS ORIGINAL']/ancestor::div[@class='card-body']//button[contains(text(),'Add To Cart')]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
        Thread.sleep(200);

        addBtn.click();
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='btn btn-custom' and contains(.,'Cart')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cartBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);

    }

    @And("I proceed to checkout")
    public void checkout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".cartSection")
        ));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Checkout')]")
        ));
        checkoutBtn.click();
    }

    @And("I place the order with CV (.+) and CardName (.+) Country (.+)$")
    public void Place_Order(String CVV, String CardName, String Country) {
        driver.findElement(By.xpath("//div[contains(text(),'CVV')]/following-sibling::input")).sendKeys(CVV);
        driver.findElement(By.xpath("//div[contains(text(),'Name')]/following-sibling::input")).sendKeys(CardName);
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Country);

        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'ta-item')]/span")));
        for (WebElement option : list) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
    }
}


