package TestProject.DataFrameWorkPro;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static String browserType;
 
    
    @BeforeTest
    @Parameters("browser")
    public void setBrowserType(@Optional("Chrome") String browser) {
        browserType = browser;
        launchBrowser();
        }
  
    public void launchBrowser() {
    	
    	if (browserType.equalsIgnoreCase("Chrome")) {
    		WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        ConfigUtil.loadTestConfigurations();
        driver.manage().deleteAllCookies();
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }
    
   @AfterTest
    public void quitDriver() {
	   driver.quit();
    } 
}

