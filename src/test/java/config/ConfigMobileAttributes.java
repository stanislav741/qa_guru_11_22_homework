package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/${device}.properties"})

public interface ConfigMobileAttributes extends Config {

    String user();

    String key();

    String url();

    String app();

    String deviceName();

    String platformName();

    String platformVersion();

    String appiumVersion();     //BrowserStack

    String projectName();       //BrowserStack

    String buildName();         //BrowserStack

    String testName();          //BrowserStack

    String appFileName();       //Local

    String appPackage();        //Local

    String appActivity();       //Local

    String locale();            //Local

    String language();          //Local

}
