package base;

import util.CompareUrl;
import config.PropertiesFile;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class BaseMethods {

    protected static final PropertiesFile properties = new PropertiesFile();

    /******************************************************************************
         INITIALIZE SELENIUM WEBDRIVER ON VIRTUAL MACHINE WITH SELENUM GRID
     *****************************************************************************/

    /*
    protected static final WebDriver driver = initializeDriver();
    */

    /******************************************************************************
                 INITIALIZE SELENIUM WEBDRIVER ON LOCAL MACHINE
     *****************************************************************************/

    public static final WebDriver driver = new ChromeDriver();

    /******************************************************************************
                          ENVIRONMENT FROM PROPERTY FILE
     *****************************************************************************/

    protected String urlenvironment = properties.getPropertyValue(PropertiesFile.PropertyKey.ENVIRONMENT);

    /******************************************************************************
                   CREDENTIALS AND PARAMETERS FROM PROPERTY FILE
     *****************************************************************************/

    protected String username = properties.getPropertyValue(PropertiesFile.PropertyKey.USERNAME);
    protected String password = properties.getPropertyValue(PropertiesFile.PropertyKey.PASSWORD);

    /******************************************************************************
            REQUIRED FOR SELENUIM GRID PATHS TO ENVIRONMENT OF HUB AND NODE
     *****************************************************************************/

    /***
     * Selenium grid
     * @return
     */

    protected static WebDriver initializeDriver() {

        String browser = properties.getPropertyValue(PropertiesFile.PropertyKey.TEST_ENV_BROWSER);
        String platform = properties.getPropertyValue(PropertiesFile.PropertyKey.TEST_ENV_OS);
        String urlString = properties.getPropertyValue(PropertiesFile.PropertyKey.TEST_ENV_URL);

        DesiredCapabilities cap;

        switch (browser) {

            case "CHROME":
                cap = DesiredCapabilities.chrome();
                break;

            case "FIREFOX":
                cap = DesiredCapabilities.firefox();
                break;

            case "IE":
                cap =  DesiredCapabilities.internetExplorer();
                break;

            case "EDGE":
                cap =  DesiredCapabilities.edge();
                break;

            default:
                cap = DesiredCapabilities.chrome();
        }

        switch (platform) {

            case "WIN10":
                cap.setPlatform(Platform.WIN10);
                break;

            case "WIN8":
                cap.setPlatform(Platform.WIN8);
                break;

            case "VISTA":
                cap.setPlatform(Platform.VISTA);
                break;

            case "LINUX":
                cap.setPlatform(Platform.LINUX);
                break;

            default:
                cap.setPlatform(Platform.LINUX);
                break;
        }

        URL url = null;

        try {
            url = new URL(urlString);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return new RemoteWebDriver(url, cap);
    }

    /******************************************************************************
                                        METHODS
     *****************************************************************************/


    WebElement el = null;

    /***
     * Browser Mximize
     */
    protected void browserMximize() {driver.manage().window().fullscreen();}

    /***
     * Open Page
     * @param urlPage
     */
    protected void openPage(String urlPage) {driver.get(urlPage);}


    /******************************************************************************
                         METHODS FOR FIND ELEMENT AND CLICK
     *****************************************************************************/

    /***
     * findElementByIdAndClick
     * @param id
     */
    protected void findElementByIdAndClick(String id){
        el = findElementById(id);
        click(el);
    }

    /***
     * findElementByXPathAndClick
     * @param xPath
     */
    protected void findElementByXPathAndClick(String xPath){
        el = findElementByXPath(xPath);
        click(el);
    }

    /***
     * findElementByCssAndClick
     * @param css
     */
    protected void findElementByCssAndClick(String css){
        el = findElementByCss(css);
        click(el);
    }

    /***
     * findElementByLinkTextAndClick
     * @param linkText
     */
    protected void findElementByLinkTextAndClick(String linkText){
        el = findElementByLinkText(linkText);
        click(el);
    }

    /***
     * findElementByClassNameAndClick
     * @param className
     */
    protected void findElementByClassNameAndClick(String className){
        el = findElementByClassName(className);
        click(el);
    }

    /***
     * findElementByTagNameAndClick
     * @param tagName
     */
    protected void findElementByTagNameAndClick(String tagName){
        el = findElementByTagName(tagName);
        click(el);
    }

    /******************************************************************************
                       METHODS FOR FIND ELEMENT AND SEND KEYS
     *****************************************************************************/


    /***
     * findElementByIdAndSendKeys
     * @param id
     * @param keys
     */
    protected void findElementByIdAndSendKeys(String id, String keys){
        el = findElementById(id);
        sendKeys(el, keys);
    }

    /***
     * findElementByXPathAndSendKeys
     * @param xPath
     * @param keys
     */
    protected void findElementByXPathAndSendKeys(String xPath, String keys){
        el = findElementByXPath(xPath);
        sendKeys(el, keys);
    }

    /***
     * findElementByCssAndSendKeys
     * @param css
     * @param keys
     */
    protected void findElementByCssAndSendKeys(String css, String keys){
        el = findElementByCss(css);
        sendKeys(el, keys);
    }

    /***
     * findElementByLinkTextAndSendKeys
     * @param linkText
     * @param keys
     */
    protected void findElementByLinkTextAndSendKeys(String linkText, String keys){
        el = findElementByLinkText(linkText);
        sendKeys(el, keys);
    }

    /***
     * findElementByClassNameAndSendKeys
     * @param className
     * @param keys
     */
    protected void findElementByClassNameAndSendKeys(String className, String keys){
        el = findElementByClassName(className);
        sendKeys(el, keys);
    }

    /***
     * findElementByTagNameAndSendKeys
     * @param tagName
     * @param keys
     */
    protected void findElementByTagNameAndSendKeys(String tagName, String keys){
        el = findElementByTagName(tagName);
        sendKeys(el, keys);
    }

    /***
     * findElementById
     * @param id
     * @return
     */
    protected WebElement findElementById(String id){
        try{
            return driver.findElement(By.id(id));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /******************************************************************************
                      METHODS FOR FIND ELEMENT WITHOUT ACTION
     *****************************************************************************/

    /***
     * findElementByXPath
     * @param xPath
     * @return
     */
    protected WebElement findElementByXPath(String xPath){
        try{
            return driver.findElement(By.xpath(xPath));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByCss
     * @param css
     * @return
     */
    protected WebElement findElementByCss(String css){
        try{
            return driver.findElement(By.cssSelector(css));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByLinkText
     * @param linkText
     * @return
     */
    protected WebElement findElementByLinkText(String linkText){
        try{
            return driver.findElement(By.linkText(linkText));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByClassName
     * @param className
     * @return
     */
    protected WebElement findElementByClassName(String className){
        try{
            return driver.findElement(By.className(className));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * findElementByTagName
     * @param tagName
     * @return
     */
    protected WebElement findElementByTagName(String tagName){
        try{
            return driver.findElement(By.tagName(tagName));
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * click
     * @param el
     */
    protected void click(WebElement el){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",el);
    }

    /***
     * sendKeys
     * @param el
     * @param keys
     */
    protected void sendKeys(WebElement el, String keys){
        el.sendKeys(keys);
    }


    /******************************************************************************
                                  METHOD FOR WAIT
     *****************************************************************************/

    /***
     * Wait for some time
     * @param waitTime
     */
    protected void waitFor(long waitTime){

        try {
            Thread.sleep(waitTime);
        }
        catch (java.lang.InterruptedException e){

        }
    }

    /******************************************************************************
                          METHOD PRINTING MESSAGE IN CONSOLE
     *****************************************************************************/

    /***
     * Print message
     * @param message
     */
    protected void logMessage(String message){
        System.out.println(message);
    }


    /******************************************************************************
                     METHODS FOR WAITING PRESENCE OF SOME ELEMENTS
     *****************************************************************************/

    /***
     * waitPresenceOfElementByCSS
     * @param css
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByCSS (String css, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementById
     * @param id
     * @param seconds
     */
    protected WebElement waitPresenceOfElementById (String id, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementByXPath
     * @param xpath
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByXPath (String xpath, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitPresenceOfElementByLinkText
     * @param linkText
     * @param seconds
     */
    protected WebElement waitPresenceOfElementByLinkText (String linkText, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /******************************************************************************
                   METHODS FOR WAITING ELEMENT TO BE CLICKABLE
     *****************************************************************************/

    /***
     * waitElementToBeClickableById
     * @param id
     * @param seconds
     */
    protected WebElement waitElementToBeClickableById (String id, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.id(id)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByCSS
     * @param css
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByCSS (String css, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByXpath
     * @param xpath
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByXpath (String xpath, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /***
     * waitElementToBeClickableByLinkText
     * @param linkText
     * @param seconds
     */
    protected WebElement waitElementToBeClickableByLinkText (String linkText, int seconds) {

        try{
            waitFor(500);
            WebElement waitElement = (new WebDriverWait(driver, seconds))
                    .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));

            return waitElement;
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            return null;
        }
    }

    /******************************************************************************
                           METHOD FOR CLOSE WEB DRIVER
     *****************************************************************************/

    /***
     * Close driver
     */
    protected void closeBrowser() {driver.close();}


    /******************************************************************************
                            METHOD FOR VALIDATION URL
     *****************************************************************************/

    /***
     * Validation URL
     * @param market
     */
    protected void validateURL (String market) {

        boolean result;

        result = CompareUrl.validateURL(driver, market);
        Assert.assertTrue("[Error - Not Matching Actual URL with Expected URL]" ,result);
    }


    /*************************************************************************************
     METHOD FOR TO SELECT OPTIONS FROM DROP DOWN LIST USING JAVASCRIPT EXECUTOR EXAMPLE
     ************************************************************************************/

    /***
     * clickOnElementInDropdownList
     * @param elementId
     * @param elementPosition
     */
    protected Object clickOnElementInDropdownList(String elementId, String elementPosition){

        String cssSelector = String.format("document.querySelectorAll('#%s .ng-dropdown-panel .ng-option')[%s]", elementId, elementPosition);

        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);

        Object result = jsExecutor.executeScript("return " + cssSelector + ".textContent;");
        jsExecutor.executeScript(cssSelector + ".click();");

        return result;
    }

    /********************************************************************************************
       METHOD FOR CHECKING TOTAL NUMBER OF VALUES IN SOME LIST USING JAVASCRIPT EXECUTOR EXAMPLE
     ********************************************************************************************/


    /***
     * checkTotalNumberOfValuesInList
     * @param elementId
     */
    protected int checkTotalNumberOfValuesInList(String elementId){

        String cssSelector = String.format("return document.querySelectorAll('#%s .ng-dropdown-panel .ng-option').length", elementId);

        Object result = ((JavascriptExecutor)driver).executeScript(cssSelector);

        int numberOfEl = 0;

        if (result != null){

            try {
                numberOfEl = Integer.parseInt(result.toString());
            }
            catch (NumberFormatException ex){

            }
        }

        return numberOfEl;
    }

    /********************************************************************************************
                  METHOD FOR CLICKING ON SOME ELEMENT USING JAVASCRIPT EXECUTOR EXAMPLE
     ********************************************************************************************/

    /***
     * clickOnSomeElementUsingJavascript
     * @param el
     */
    protected void clickOnSomeElementUsingJavascript(String el){
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('a.link')"+"["+el+"].click()");
    }


    /*********************************************************************************************************
      METHOD FOR RETURNING TEXT FROM ELEMENT AND COMPARE WITH ANOTHER TEXT USING JAVASCRIPT EXECUTOR EXAMPLE
     *********************************************************************************************************/

    /***
     * returnTextFromElement
     */
    protected void returnTextFromElement(int numberOfColumn, String expectedText){

        String returnTextFromElement = String.format("return document.querySelectorAll('a.link')"+"["+ numberOfColumn +"].innerText.trim()");

        Object actualText = ((JavascriptExecutor)driver).executeScript(returnTextFromElement);

        assertEquals(actualText, expectedText);
    }
}