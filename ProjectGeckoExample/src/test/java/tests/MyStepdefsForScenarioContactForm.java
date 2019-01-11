package tests;

import org.apache.commons.mail.EmailException;
import org.junit.Test;
import util.GetScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import base.BaseMethods;
import util.SendEmailJava;

import java.io.IOException;

public class MyStepdefsForScenarioContactForm extends BaseMethods {


    @After("@feature_one")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            GetScreenshot.capture(driver, "CaptureScreenShot");
        }
    }

    @Given("^Open Gecko home page$")
    public void openGeckoHomePage() throws Throwable {

        String HomePageURL = "https://www.gecko.rs/";

        // Authentication pass
        //String URL = "http://" + username + ":" + password + "@" + urlenvironment;    //"http:// + username + ":" + password + "@" + "link";

        openPage(urlenvironment);

        browserMximize();

        logMessage("01.Successfully open Gecko home page");

        validateURL(HomePageURL);

    }

    @And("^Click on link Contact us$")
    public void clickOnLinkContactUs() throws Throwable {

        waitPresenceOfElementByLinkText("Contact", 20);

        waitElementToBeClickableByLinkText("Contact", 20);

        findElementByLinkTextAndClick("Contact");

        logMessage("02.Click on link Contact us");

    }

    @And("^Click on button for Send message$")
    public void clickOnButtonForSendMessage() throws Throwable {

        waitPresenceOfElementById("edit-submit", 20);

        waitElementToBeClickableById("edit-submit", 20);

        findElementByIdAndClick("edit-submit");

        logMessage("03.Click on button for Send message");
    }

    @Then("^Verify that in this case User can not send message$")
    public void verifyThatInThisCaseUserCanNotSendMessage() throws Throwable {

        waitPresenceOfElementByCSS("div.messages--error", 20);

        if (findElementByCss("div.messages--error") != null){

            logMessage("04.Verify that in this case User can not send message");

        }else {

            throw new Exception("ERROR - User successfully send message");
        }
    }

    @And("^Enter valid data ([^\"]*) in field Your name$")
    public void enterValidDataTestDataForFieldYourNameInFieldYourName(String testDataForFieldYourName) throws Throwable {

        waitPresenceOfElementById("edit-name", 20);

        waitElementToBeClickableById("edit-name", 20);

        findElementByIdAndSendKeys("edit-name", testDataForFieldYourName);

        logMessage("03.Enter valid data in field Your name");

    }

    @And("^Enter valid data ([^\"]*) in field Your Email address$")
    public void enterValidDataTestDataForFieldYourEmailAddressInFieldYourEmailAddress(String testDataForFieldYourEmailAddress) throws Throwable {

        waitPresenceOfElementById("edit-mail", 20);

        waitElementToBeClickableById("edit-mail", 20);

        findElementByIdAndSendKeys("edit-mail", testDataForFieldYourEmailAddress);

        logMessage("03.Enter valid data in field Your Email address");
    }

    @And("^Click on button for Send message after entering data in field Your name$")
    public void clickOnButtonForSendMessageAfterEnteringDataInFieldYourName() throws Throwable {

        waitPresenceOfElementById("edit-submit", 20);

        waitElementToBeClickableById("edit-submit", 20);

        findElementByIdAndClick("edit-submit");

        logMessage("04.Click on button for Send message");
    }

    @And("^Click on button for Send message after entering data in field Your Email address$")
    public void clickOnButtonForSendMessageAfterEnteringDataInFieldYourEmailAddress() throws Throwable {

        waitPresenceOfElementById("edit-submit", 20);

        waitElementToBeClickableById("edit-submit", 20);

        findElementByIdAndClick("edit-submit");

        logMessage("04.Click on button for Send message");
    }

    @Then("^Verify that in this case User can not send message if he enter submit only field Your name$")
    public void verifyThatInThisCaseUserCanNotSendMessageIfHeEnterSubmitOnlyFieldYourName() throws Throwable {

        waitPresenceOfElementByCSS("div.messages--error", 20);

        if (findElementByCss("div.messages--error") != null){

            logMessage("05.Verify that in this case User can not send message");

        }else {

            throw new Exception("05.ERROR - User successfully send message");
        }

    }

    @Then("^Verify that in this case User can not send message if he enter submit only field Your Email address$")
    public void verifyThatInThisCaseUserCanNotSendMessageIfHeEnterSubmitOnlyFieldYourEmailAddress() throws Throwable {

        waitPresenceOfElementByCSS("div.messages--error", 20);

        if (findElementByCss("div.messages--error") != null){

            logMessage("05.Verify that in this case User can not send message");

        }else {

            throw new Exception("05.ERROR - User successfully send message");
        }
    }
}