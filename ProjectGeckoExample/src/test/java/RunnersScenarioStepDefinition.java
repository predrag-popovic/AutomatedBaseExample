import base.BaseMethods;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.commons.mail.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import util.SendEmailJava;
import org.apache.commons.mail.EmailException;
import util.ZipDirectory;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/cucumber.json",
                "html:target/site/cucumber-pretty",
                "pretty"
        },

        features = {"src/test/java/resources/"},

        glue = "tests",

        plugin = {"html:target/cucumber",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
        },

        tags = {"~@disable_this_scenario"},

        monochrome = false
)

public class RunnersScenarioStepDefinition extends BaseMethods {

    /******************************************************************************
     Add ENV information on extent report
     *****************************************************************************/

    @AfterClass
    public static void writeExtentReport() {

        Reporter.loadXMLConfig("src/test/java/config/extent-config.xml");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }

    /******************************************************************************
     Sending E-mail notification after build job is finish
     *****************************************************************************/

    @AfterClass
    public static void sendEmail() throws EmailException {

        SendEmailJava.sendEmail();
    }

    /******************************************************************************
     Zip Directory
     *****************************************************************************/

    /*
    @AfterClass
    public static void zipDirectory() throws IOException {

        ZipDirectory.zip();
    }
     */

}