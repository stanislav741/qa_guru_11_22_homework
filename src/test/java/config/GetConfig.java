package config;

import org.aeonbits.owner.ConfigFactory;

public class GetConfig {
    public static ConfigMobileAttributes config = ConfigFactory
            .create(ConfigMobileAttributes.class, System.getProperties());

    public static String getUser() {
        return config.user();
    }

    public static String getKey() {
        return config.key();
    }

    public static String getApp() {
        return config.app();
    }

    public static String getUrl() {
        return config.url();
    }

    public static String getDeviceName() {
        return config.deviceName();
    }

    public static String getPlatformName() {
        return config.platformName();
    }

    public static String getPlatformVersion() {
        return config.platformVersion();
    }

    public static String getAppiumVersion() {
        return config.appiumVersion();
    }

    public static String getProjectName() {
        return config.projectName();
    }

    public static String getBuildName() {
        return config.buildName();
    }

    public static String getTestName() {
        return config.testName();
    }

    public static String getAppFileName() {
        return config.appFileName();
    }

    public static String getAppPackage() {
        return config.appPackage();
    }

    public static String getAppActivity() {
        return config.appActivity();
    }

    public static String getLocale() {
        return config.locale();
    }

    public static String getLanguage() {
        return config.language();
    }

}
