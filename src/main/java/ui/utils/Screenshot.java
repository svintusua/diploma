package ui.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Screenshot {

    public static final Logger LOGGER = Logger.getLogger(Screenshot.class.getName());

    public static void takeScreenshotFullPage(String attachmentName) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            WebDriver webDriver = new Augmenter().augment(getWebDriver());
            BufferedImage bufferedImage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(webDriver).getImage();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            saveScreenshot(attachmentName, baos.toByteArray());
            ((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0,0);");
        } catch (RuntimeException ex) {
            LOGGER.severe("Невозможно сохранить скриншот: " + ex);
        }

    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveScreenshot(String name, byte[] screenshot) {
        return screenshot;
    }
}
