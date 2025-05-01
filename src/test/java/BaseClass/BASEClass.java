package BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;  // Corrected import for Date
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BASEClass 
{
    public static WebDriver driver;
    public WebDriverWait wait;
    public Logger logger;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger = LogManager.getLogger(this.getClass()); // log4j2

        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterClass
    public void close() 
    {
        driver.quit();
    }

    public String captureScreen(String tname) throws IOException 
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Corrected Date usage

        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String path = "D:\\SBE_SOFTWARE\\ParaBank\\ScreenShots\\" + tname + timeStamp + ".png"; // Added missing backslash for correct path
        File targetfile = new File(path);

        FileUtils.copyFile(source, targetfile);
        return path;
    }
}