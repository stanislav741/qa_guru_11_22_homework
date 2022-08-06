package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.GetConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl()  {

        try {
            return new URL(GetConfig.getUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", GetConfig.getAppiumVersion());
        mutableCapabilities.setCapability("browserstack.user", GetConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", GetConfig.getKey());
        mutableCapabilities.setCapability("app", GetConfig.getApp());
        mutableCapabilities.setCapability("device", GetConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", GetConfig.getPlatformVersion());
        mutableCapabilities.setCapability("project", GetConfig.getProjectName());
        mutableCapabilities.setCapability("build", GetConfig.getBuildName());
        mutableCapabilities.setCapability("name", GetConfig.getTestName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

}
