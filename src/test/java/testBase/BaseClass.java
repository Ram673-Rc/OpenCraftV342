package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"sanity","regression","master"})
    @Parameters({"os","browser"})
    public void setup(String os,String bro) throws IOException {
     FileReader file=new FileReader("C:\\Workspace\\Selenium workspace folder\\OpenCraftV342\\src\\main\\resources\\config.properities");
    	p=new Properties();
    	p.load(file);
        logger = LogManager.getLogger(this.getClass()); // Initialize logger
        
    switch(bro.toLowerCase()) {
    case "chrome":driver=new ChromeDriver();break;
    case "edge" : driver=new EdgeDriver();break;
    case "firefox": driver=new FirefoxDriver();break;
    default:System.out.println("Invavlid browser start...");return; 
    }
        driver = new ChromeDriver(); // Initialize ChromeDriver

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("appURL"));
    }

    // Random string generator
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    // Random number generator
    public String randomNumber() {
        return RandomStringUtils.randomNumeric(5);
    }

    // Random alphanumeric password generator
    public String randomAlphaNumeric() {
        String generated = RandomStringUtils.randomAlphabetic(5);
        String generatedNumber = RandomStringUtils.randomNumeric(5);
        return generated + "@" + generatedNumber;
    }

    @AfterClass(groups = {"sanity","regression","master"})
    public void tearDown() {
        driver.close(); // Use quit() to close all browser windows and safely end the session
    }
}
