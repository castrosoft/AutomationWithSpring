import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

import static org.testng.Assert.assertEquals;

public class GoogleHomeTest {

    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "./src/test/java/driver/chromedriver");
        googleHomePage = new GoogleHomePage(driver);
        driver = googleHomePage.chromeDriverConnection();
        driver.manage().window().maximize();
        googleHomePage.visit("https://www.google.com/");
    }

    @Test
    public void testGooglePage() {
        googleHomePage.write();
        assertEquals("Introduccion a automation - Buscar con Google", driver.getTitle());
    }


    @AfterClass
    public void afterClass() {

        driver.close();
    }
}
