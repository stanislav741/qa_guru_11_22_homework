package config;

import org.aeonbits.owner.ConfigFactory;

public class GetConfig {
    public static ConfigMobileAttributes config = ConfigFactory
            .create(ConfigMobileAttributes.class, System.getProperties());

//    public static String getUser() {
//        return config.user();
//    }
//
//    public static String getKey() {
//        return config.key();
//    }
//
//    public static String getUrl() {
//        return config.url();
//    }


}
