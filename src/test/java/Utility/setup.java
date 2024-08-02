package Utility;

import DriverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class setup {
    public WebDriver driver;
    private String applicationUrl;
    private int implicitWaitSeconds;
    //private int explicitWaitSeconds;
    public String username;
    protected String ProblemUser;
    protected String LockedUser;
    public String password;
    protected String product;


    @BeforeTest
    public void setUp() throws IOException {
        setupBrowser();
        loadURL();

    }
    @AfterTest
    public void tearDown (){
        driver.quit();
    }

    //Browser setup with switch Case
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
        switch (browser) {
            case "chrome" -> setupChromeDriver(implicitWaitSeconds);
            case "firefox" -> setupFirefoxDriver(implicitWaitSeconds);
            case "safari" -> setupSafariDriver(implicitWaitSeconds);
            default -> System.out.println("Incorrect driver in resources.properties");
        }

    }

    private void loadURL() {
        driver.get(applicationUrl);
    }

    private void setupChromeDriver(int implicitWaitSeconds){

        driver = DriverFactory.GetChromeDriver(implicitWaitSeconds);

    }
    private void setupFirefoxDriver(int implicitWaitSeconds){

        driver = DriverFactory.GetFirefoxDriver(implicitWaitSeconds);

    }
    private void setupSafariDriver(int implicitWaitSeconds){

        driver = DriverFactory.GetSafariDriver(implicitWaitSeconds);

    }


}
