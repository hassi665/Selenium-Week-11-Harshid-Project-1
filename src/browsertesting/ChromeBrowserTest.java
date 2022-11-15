package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class ChromeBrowserTest {

    public static void main(String[] args) {

        String baseURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //launch the URL in browser
        driver.get(baseURL);
        //maximize browser
        driver.manage().window().maximize();
        //We give implicit time to driver
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
