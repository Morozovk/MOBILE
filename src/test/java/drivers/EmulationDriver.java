package drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulationDriver implements WebDriverProvider {

    private static final EmulationConfig config = ConfigFactory.create(EmulationConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options caps = new UiAutomator2Options();
        caps.merge(capabilities);

        caps.setPlatformName(config.platform());
        caps.setDeviceName(config.emulationDevice());
        caps.setPlatformVersion(config.emulationOsVersion());

        File appFile = new File(config.appPath());
        if (!appFile.exists()) {
            throw new RuntimeException("Файл приложения не найден: " + config.appPath());
        }

        caps.setApp(new File(config.appPath()).getAbsolutePath());
        caps.setAppPackage(config.emulationSetAppPackage());
        caps.setAppActivity(config.emulationSetAppActivity());
        caps.setAutomationName(config.automationName());

        try {
            return new AndroidDriver(new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Некорректный URL", e);
        }
    }
}
