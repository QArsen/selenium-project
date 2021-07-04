package Base;

import Logger.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


 public abstract class BaseClass {

    public static WebDriver driver;
    public static Properties prop;


    public BaseClass() {
        driverInitialization();
    }

    private void driverInitialization() {
        if (driver == null) {
            Log.info("start the Driver initialization process");

            try {
                prop = new Properties();
                String confPath = "src\\main\\java\\config\\config.properties";
                FileInputStream ip = new FileInputStream(confPath);
                prop.load(ip);
                Log.debug("reading Property file");
            } catch (IOException e) {
                e.printStackTrace();
                Log.error("check your Property file");
            }
            if (prop.getProperty("browser").equalsIgnoreCase("ch")) {
                WebDriverManager.chromedriver().setup();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                driver = new ChromeDriver();
                Log.debug("Chrome browser is opening");
                manageDriver();
            } else {
                if (prop.getProperty("browser").equalsIgnoreCase("ff")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    Log.debug("FF browser is opening");
                    manageDriver();
                } else {
                    if (prop.getProperty("browser").equalsIgnoreCase("ed")) {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        Log.debug("Edge browser is opening");
                        manageDriver();
                    }
                }
            }
        }
    }

    private void manageDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    private void screenShot(ITestResult testResult) throws IOException {
        screenShotOnFailure(testResult);
    }

    @AfterClass
    public  void quit() throws IOException {
        Log.info("quit process");
        driver.quit();
        Log.info("killing the driver process");
        killWindowsProcessAfterTestFinished();
    }

    private static void killWindowsProcessAfterTestFinished() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        Log.debug("driver process is killed");
    }

    private static void screenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Log.info("print screen creation process, printScreen available at " + "C:\\temp\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\temp\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
    }
}



