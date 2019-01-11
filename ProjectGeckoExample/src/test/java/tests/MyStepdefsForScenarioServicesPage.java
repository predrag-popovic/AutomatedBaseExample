package tests;

import util.GetScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import base.BaseMethods;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MyStepdefsForScenarioServicesPage extends BaseMethods {

    @After("@feature_three")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            GetScreenshot.capture(driver, "CaptureScreenShot");
        }
    }

    @And("^Click on page for Services$")
    public void clickOnPageForServices() throws Throwable {

        waitPresenceOfElementByLinkText("Services", 10);
        waitElementToBeClickableByLinkText("Services", 10);

        findElementByLinkTextAndClick("Services");

    }

    @Then("^Verify the page for Services is present$")
    public void verifyThePageForServicesIsPresent() throws Throwable {

        String expected = "In our portfolio, we cover a wide range of solutions and services in the area of software engineering, while keeping up with latest technologies.";

        waitFor(1500);

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        String actual = js1.executeScript("return document.querySelectorAll('div.hero-desc')[0].innerText.trim()").toString();

        assertEquals(actual, expected);
    }
}
