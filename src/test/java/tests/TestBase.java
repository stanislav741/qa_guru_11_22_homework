package tests;

import com.codeborne.selenide.Configuration;
import drivers.LocalMobileDriver;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = null;

        switch (System.getProperty("device")) {
            case "emulator":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;

        }
    }
}
