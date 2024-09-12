package almosaferPart2;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestData {

    // WebDriver instance for controlling the Chrome browser
    protected static WebDriver driver = new ChromeDriver();

    // URL of the specific hotel page
    protected static String url1 = "https://www.almosafer.com/ar/hotel/details/atg/%D9%81%D9%86%D8%AF%D9%82-%D9%83%D8%B1%D8%A7%D9%88%D9%86-%D8%B1%D9%88%D8%B2-1798809";

    // URL of the general hotel search page
    protected static String url2 = "https://global.almosafer.com/en";

    // Random instance for generating random values
    Random random = new Random();

    // Setup method to initialize WebDriver and configure browser settings
    @BeforeTest
    public void setUpDriver() {
        // Navigate to the hotel page URL
        driver.get(url1);
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Set implicit wait time for WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }
}
