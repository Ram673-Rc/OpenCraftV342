package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calculation {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();
        
        String filePath = System.getProperty("user.dir") + "\\testData\\Calculation.xlsx";
        int row = ExcelUtility.getRowCount(filePath, "Sheet1");

        for (int i = 1; i <= row; i++) {
            // Read data from Excel
            String pric = ExcelUtility.getCellData(filePath, "Sheet1", i, 0);
            String rateOfInterest = ExcelUtility.getCellData(filePath, "Sheet1", i, 1);
            String Per1 = ExcelUtility.getCellData(filePath, "Sheet1", i, 2);
            String Per2 = ExcelUtility.getCellData(filePath, "Sheet1", i, 3);
            String fre = ExcelUtility.getCellData(filePath, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtility.getCellData(filePath, "Sheet1", i, 5);
            
            // Pass above data into application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Per1);
            
            Select pro = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            pro.selectByVisibleText(Per2);
            
            Select new1 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            new1.selectByVisibleText(fre);
            
            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); // Click on calculate

            // Validation
            String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
            try {
                if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
                    System.out.println("Test Passed");
                    ExcelUtility.setCellData(filePath, "Sheet1", i, 7, "passed");
                    ExcelUtility.fillGreenColor(filePath, "Sheet1", i, 7);
                } else {
                    System.out.println("Test Failed");
                    ExcelUtility.setCellData(filePath, "Sheet1", i, 7, "failed");
                    ExcelUtility.fillRedColor(filePath, "Sheet1", i, 7);  // Changed to red color for failed case
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in expected or actual values");
                ExcelUtility.setCellData(filePath, "Sheet1", i, 7, "error");
                ExcelUtility.fillRedColor(filePath, "Sheet1", i, 7);
            }

            Thread.sleep(2000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click(); // Clicked on clear button
        }
        
        driver.quit();
    }
}
