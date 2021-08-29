import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoqaTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Demoqa demoqa = new Demoqa(driver);
        demoqa.demoQA();
    }

    @DisplayName("Go to URL")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows OS")
   @Test
        public void goToUrl() {
    }

    @DisplayName("Search for demoqa.com")
    @Test
        void searchDemoQa() {
        }

    @Test
    @DisplayName("Hit the first result which will navigate to demoqa.com")
    public void clickOnFirstResult() {
    }

    @Test
    @DisplayName("Navigate to Droppable element in Interactions section")
    public void clickOnInteractionsSection() {
    }

    @Test
    @DisplayName("Pick and drop the “Drag me” box into the “Drop here” box, print out the text from the “Drop here” box")
    public void dragMeIntoDropMe() {

    }

/*
    @Test
    @DisplayName("Take a screenshot")
    public void enableScreenshot(ChromeDriver driver) {

        ScreenshotPngTest.imageFile = new File(
                "screenshotTest_arg0_chrome_" + driver.getSessionId() + ".png");



        Assertions.assertTrue(true,  "  " + ScreenshotPngTest.imageFile.exists());


    }
*/

    @Test
    @DisplayName("Click on the ToolTips link on the left hand side in the Widgets section")
    public void clickOnToolTips() {
    }

    @Test
    @DisplayName("Move your cursor to the “Hover me to see” button input element and print out the text from the pop-up tooltip")
    public void printOutTheText() {
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}