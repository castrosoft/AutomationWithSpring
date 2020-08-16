package initialTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/java/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchBox = driver.findElement(By.name("q"));
		
		//Limpia cualquier texto en la caja de busqueda
		searchBox.clear();
		
		//Envia al buscador el texto
		searchBox.sendKeys("Introduccion a automation");
		
		//"Enter"
		searchBox.submit();
		
		//Delay para que Google recupere los resultados. Esto evita un falso positivo
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit wait
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		//Condicion por la que estoy esperando
		ewait.until(ExpectedConditions.titleContains("Introduccion a automation"));
		
		assertEquals("Introduccion a automation - Buscar con Google", driver.getTitle());
	}

	@Test
	public void testFacebookPage(){
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("Facebook");
		searchBox.submit();
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.titleContains("Facebook"));
		assertEquals("Facebook - Buscar con Google", driver.getTitle());
	}
	
	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
