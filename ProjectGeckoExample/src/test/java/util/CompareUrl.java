package util;

import org.openqa.selenium.WebDriver;
import base.BaseMethods;

public class CompareUrl extends BaseMethods {

    public static boolean validateURL (WebDriver driver, String expURL) {

        boolean result = false;

        if(driver.getCurrentUrl().equalsIgnoreCase(expURL))

        {
            result = true;
        }

        return result;
    }

}
