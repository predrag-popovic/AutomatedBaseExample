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

public class MyStepdefsForScenarioNewsPage extends BaseMethods {

    @After("@feature_two")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            GetScreenshot.capture(driver, "CaptureScreenShot");
        }
    }

    @And("^Click on page for News$")
    public void clickOnPageForNews() throws Exception {

        waitPresenceOfElementByLinkText("News", 10);
        waitElementToBeClickableByLinkText("News", 10);

        findElementByLinkTextAndClick("News");
    }

    @Then("^Verify the page for News is present$")
    public void verifyThePageForNewsIsPresent() throws Exception {

        String expected = "AAA Creditworthiness For Gecko 2017";

        waitFor(1500);

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        String actual = js1.executeScript("return document.querySelectorAll('h1')[0].innerText.trim()").toString();

        assertEquals(actual, expected);

    }
}
