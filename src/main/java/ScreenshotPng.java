
import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.github.bonigarcia.seljup.SeleniumJupiter;

class ScreenshotPngTest {

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    static File imageFile;

    @BeforeAll
    static void setup() {
        seleniumJupiter.getConfig().enableScreenshotAtTheEndOfTests();
        seleniumJupiter.getConfig().takeScreenshotAsPng(); // Default option
    }

    @AfterAll
    static void teardown() {
        imageFile.exists();
        imageFile.delete();
    }
}
