package DriverFactory;

import Pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {



    public static WebDriver GetChromeDriver(int implicitWaitSeconds){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }
    public static WebDriver GetFirefoxDriver(int implicitWaitSeconds){
        WebDriverManager.firefoxdriver().getWebDriver();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }

    public static WebDriver GetSafariDriver(int implicitWaitSeconds) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }
}
