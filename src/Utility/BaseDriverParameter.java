package Utility;

import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi) {


        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase()) {
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                //  driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
        }


        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginTest();

    }

    public void loginTest() {
        driver.get(" https://admin-demo.nopcommerce.com/login?");
        ProjePOM pm = new ProjePOM();
        pm.loginBtn.click();

    }


    @AfterClass
    public void bitisIslemleri() {
        Tools.bekle(3);
        driver.quit();

    }
}