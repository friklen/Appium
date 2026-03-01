package ru.netology.mobail;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MobileObjects {

    // Привязываем элементы к их ID в приложении
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public WebElement userInputField;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public WebElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public WebElement resultField;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public WebElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text") // ID на втором экране
    public WebElement secondActivityResultField;

    public MobileObjects(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}

