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
    public static String CHROMEDRIVER_PATH = "src/test/resources/chromedriver.exe";
    public static String EDGEDRIVER_PATH = "src/test/resources/msedgedriver.exe";

    public static void configFromFileConfig() {
        try {
            File file = new File("Config.ini");
            Ini ini = new Ini(file);
            if (file.exists()) {
                if (ini.get("configuration", "BROWSER") != null)
                    BROWSER = ini.get("configuration", "BROWSER");
                if (ini.get("configuration", "USERNAME") != null)
                    USERNAME = ini.get("configuration", "USERNAME");
                if (ini.get("configuration", "CHROMEDRIVER_PATH") != null)
                    CHROMEDRIVER_PATH = ini.get("configuration", "CHROMEDRIVER_PATH");
                if (ini.get("configuration", "EDGEDRIVER_PATH") != null)
                    CHROMEDRIVER_PATH = ini.get("configuration", "EDGEDRIVER_PATH");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
