package Utility;

import DriverFactory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class setup {
    public WebDriver driver;
    private String applicationUrl;
    private int implicitWaitSeconds;
    private int explicitWaitSeconds;
    public String username;
    protected String ProblemUser;
    protected String LockedUser;
    public String password;



    @BeforeMethod
    public void setUp() throws IOException {
        setupBrowser();
        loadURL();
    }
    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

    private void loadURL() {
        driver.get(applicationUrl);
    }

    private void setupChromeDriver(int implicitWaitSeconds){

      DriverFactory.GetChromeDriver(implicitWaitSeconds);

    }
    private void setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));

    }
    private void setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));

    }

    private void setupBrowser() throws IOException {

        FileInputStream cfgFile = new FileInputStream("src/test/resources/resources.properties");
        Properties configs = new Properties();
        configs.load(cfgFile);
        username = configs.getProperty("username");
        password = configs.getProperty("password");
        ProblemUser = configs.getProperty("problemUser");
        LockedUser = configs.getProperty("usernameLocked");
        applicationUrl = configs.getProperty("url");
        implicitWaitSeconds = Integer.parseInt(configs.getProperty("implicitWait"));
        String browser = configs.getProperty("browser");
        if (browser.equals("chrome")){
            setupChromeDriver(implicitWaitSeconds);
        }
        // safari not yet tested
        if (browser.equals("safari")){
            setupSafariDriver();
        }
        else {
            setupFirefoxDriver();
        }

    }


}
