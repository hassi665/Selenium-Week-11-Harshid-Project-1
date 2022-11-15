package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "firefox";
    static String baseURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver", "drivers/firefox.exe");
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println(" Wrong Browser Name ");
        }
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Print the title of the page
        System.out.println("Page title is : " + driver.getTitle());

        //Print the Current URL
        System.out.println("Current URL: "+ driver.getCurrentUrl());

        //Print the Page Source
        System.out.println("Page Source: " + driver.getPageSource());

        //Enter the email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("harshid.prime123@gmail.com");

        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Harshid@prime_123");

        //Close the browser
        driver.close();

    }
}
