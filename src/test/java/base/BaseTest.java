package base;

import config.ConfigManager;
import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;

@Listeners(BaseTest.class)
public class BaseTest implements ITestListener {
    protected ConfigManager config;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        config = ConfigManager.getInstance();
        DriverManager.setDriver(config.getBrowser());
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}