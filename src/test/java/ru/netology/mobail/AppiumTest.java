package ru.netology.mobail;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", "true");
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", "true");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), desiredCapabilities);
    }

    @Test
    public void testSetEmptyText() {
        MobileObjects mainScreen = new MobileObjects(driver);
        String expectedText = "Привет, UiAutomator!";
        mainScreen.userInputField.sendKeys("   ");
        mainScreen.buttonChange.click();
        Assertions.assertEquals(expectedText, mainScreen.resultField.getText());
    }

    @Test
    public void testAnotherActivity() {
        MobileObjects mainScreen = new MobileObjects(driver);
        String textToVerify = "Hello, activity";
        mainScreen.userInputField.sendKeys(textToVerify);
        mainScreen.buttonActivity.click();
        Assertions.assertEquals(textToVerify, mainScreen.secondActivityResultField.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
