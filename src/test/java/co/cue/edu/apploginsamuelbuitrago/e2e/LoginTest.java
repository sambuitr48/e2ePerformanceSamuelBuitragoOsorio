package co.cue.edu.apploginsamuelbuitrago.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private static WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080";
    private static final String TEST_EMAIL = "testusuario@demo.com";
    private static final String TEST_PASSWORD = "abc123";

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    public void registroDeUsuario() {
        driver.get(BASE_URL + "/register");

        driver.findElement(By.id("email")).sendKeys(TEST_EMAIL);
        driver.findElement(By.id("password")).sendKeys(TEST_PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        boton.click();

        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        assertTrue(mensaje.getText().contains("Usuario registrado"), "Mensaje de registro no detectado");
    }


    @Test
    @Order(2)
    public void loginDelUsuarioRegistrado() {
        driver.get(BASE_URL + "/login");

        // Solo verificar que aparece el mensaje de éxito
        WebElement mensaje = driver.findElement(By.className("message"));
        assertTrue(mensaje.getText().contains("Login exitoso"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
