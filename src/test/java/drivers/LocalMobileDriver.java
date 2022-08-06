package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.GetConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(GetConfig.getPlatformName());
        options.setDeviceName(GetConfig.getDeviceName());
        options.setPlatformVersion(GetConfig.getPlatformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale(GetConfig.getLocale());
        options.setLanguage(GetConfig.getLanguage());
        options.setAppPackage(GetConfig.getAppPackage());
        options.setAppActivity(GetConfig.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(GetConfig.getUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appPath = "src/test/resources/apk/" + GetConfig.getAppFileName();
        String appUrl = GetConfig.getApp();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }

}
