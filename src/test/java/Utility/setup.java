package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class setup {
    public WebDriver driver;
    private String applicationUrl , browser;
    private int implicitWaitSeconds;
    private int explicitWaitSeconds;
     public String username;
    protected String ProblemUser;
    protected String LockedUser;
    public String password;



    @BeforeClass
    public void setUp() throws IOException {
        setupBrowser();
        loadURL();
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/Login.properties");
            prop.load(input);
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            ProblemUser = prop.getProperty("problemUser");
            LockedUser = prop.getProperty("usernameLocked");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void tearDown (){
        driver.quit();
    }
    private void loadURL() {
        driver.get(applicationUrl);
    }


    private void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(explicitWaitSeconds));


    }
    private void setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(explicitWaitSeconds));
    }
    private void setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(explicitWaitSeconds));
    }

    private void setupBrowser() throws IOException {

        FileInputStream cfgFile = new FileInputStream("src/test/resources/resources.properties");
        Properties configs = new Properties();
        configs.load(cfgFile);
        applicationUrl = configs.getProperty("url");
        explicitWaitSeconds = Integer.parseInt(configs.getProperty("explicitWait"));
        implicitWaitSeconds = Integer.parseInt(configs.getProperty("implicitWait"));
        browser = configs.getProperty("browser");
        if (browser=="chrome"){
            setupChromeDriver();
        }
        // safari not yet tested
        if (browser=="safari"){
            setupSafariDriver();
        }
        else {
            setupFirefoxDriver();
        }

    }


}
