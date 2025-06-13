package co.cue.edu.apploginsamuelbuitrago.e2e;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1280, 800));
    }

    @Test
    @Order(1)
    public void registroDeUsuario() {
        driver.get(BASE_URL + "/register");

        driver.findElement(By.id("email")).sendKeys(TEST_EMAIL);
        driver.findElement(By.id("password")).sendKeys(TEST_PASSWORD);
        driver.findElement(By.tagName("button")).click();

        WebElement mensaje = driver.findElement(By.className("message"));
        assertTrue(mensaje.getText().contains("Usuario registrado"), "Mensaje de registro no detectado");
    }

    @Test
    @Order(2)
    public void loginDelUsuarioRegistrado() {
        driver.get(BASE_URL + "/login");

        driver.findElement(By.id("email")).sendKeys(TEST_EMAIL);
        driver.findElement(By.id("password")).sendKeys(TEST_PASSWORD);
        driver.findElement(By.tagName("button")).click();

        WebElement mensaje = driver.findElement(By.className("message"));
        assertTrue(mensaje.getText().contains("Login exitoso"), "Login no fue exitoso");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
