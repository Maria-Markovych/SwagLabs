package tests;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;


public class Config {
    public static String BROWSER = "Chrome";
    public static final int IMPLICIT_WAIT = 4;
    public static final int EXPLICIT_WAIT = 10;
    public static final String BASE_PATH = "https://www.saucedemo.com/";
    public static String USERNAME = "standard_user";
    public static final String CHROMEDRIVER_PATH = "src/test/resources/chromedriver.exe";
    public static final String EDGEDRIVER_PATH = "src/test/resources/msedgedriver.exe";

    public static void configFromFileConfig() {
        try {
            File file = new File("Config.ini");
            Ini ini = new Ini(file);
            if (file.exists()) {
                if (ini.get("configuration", "Browser") != null)
                    BROWSER = ini.get("configuration", "BROWSER");
                if (ini.get("configuration", "Username") != null)
                    USERNAME = ini.get("configuration", "USERNAME");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
