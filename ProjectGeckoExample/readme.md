# Automatic Basic Framework

This basic framework example using JAVA programming language with integrated Cucumber framework.
Automatic test used Selenium WebDriver (Chrome, Firefox, Edge, Safari) for executing tests and also this
framework have support for Selenium Grid.

# New Features

  - Choose your Browser where you want to run your tests on local machine or using HUB and NODES
  - Writing a test case using Gherkin syntax
  - Generate two Report after test is finish 

You can also:

  - Get Screenshot if test is failed
  - Send email notification when test is finish

### Tech

Automatic Basic Framework in order to work properly uses a number of dependencie:

* [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) - For Java Developers. Includes a complete JRE plus tools for developing, debugging, and monitoring Java applications.
* [Cucmber](https://docs.cucumber.io/) - Behaviour-Driven Development (BDD).
* [Selenium](https://www.seleniumhq.org/download/) - Selenium has the support of some of the largest browser
* [Selenium Grid](https://www.seleniumhq.org/docs/07_selenium_grid.jsp) - Selenium-Grid allows you run your tests on different machines against different browsers in parallel.
* [Log4j](https://logging.apache.org/log4j/2.x/) - Almost every large application includes its own logging or tracing API. 

And of course Automatic Basic Framework itself is open source with a [public repository]
 on GitHub.

### Installation

Automatic Basic Framework requires [Maven](https://maven.apache.org/download.cgi) v3.6.0+ to run.

Install the dependencies or put them in POM.xml file into your project:

```sh
Dependencies list:
[selenium-java] - (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) v3.12.0+
[junit] - (https://mvnrepository.com/artifact/junit/junit) v4.12
[cucumber-java] - (https://mvnrepository.com/artifact/info.cukes/cucumber-java) v1.2.5+
[cucumber-junit] - (https://mvnrepository.com/artifact/junit/junit) v1.2.2+
[cucumber-picocontainer] - (https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer) v1.2.5+
[maven-cucumber-reporting] - (https://mvnrepository.com/artifact/net.masterthought/maven-cucumber-reporting) v3.14.0+
[com.vimalselvam] - (https://mvnrepository.com/artifact/com.vimalselvam/cucumber-extentsreport) v3.0.2+
[extentreports] - (https://mvnrepository.com/artifact/com.aventstack/extentreports) v4.0.5+
[commons-email] - (https://mvnrepository.com/artifact/org.apache.commons/commons-email) v1.5+
[webdrivermanager] - (https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager) v3.2.0+
[log4j] - (https://mvnrepository.com/artifact/log4j/log4j) v1.2.17+
[slf4j-log4j12] - (https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12) v1.7.25+
```

### Plugins

Automatic Basic Framework is currently extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Cucumber | https://cucumber.io/ |

### Selenium WebDriver

This automatic test is written in JAVA, using Selenium WebDriver and Cucumber. Also I need to mention this is a Maven project.

Selenium WebDriver tool is used to automate web application testing to verify that it works as expected. It supports many browsers such as Firefox, Chrome, IE, and Safari. 

However, using the Selenium WebDriver, we can automate testing for web applications only. It does not qualify for window-based applications. It also supports different programming languages such as C#, Java, Perl, PHP and Ruby for writing test scripts. 

For more, read documentation:
[Selenium documentation](https://www.seleniumhq.org/docs/)

### Cucumber

Cucumber and Selenium are two popular technologies.

Most of the organizations use Selenium for functional testing. These organizations which are using Selenium want to integrate Cucumber with selenium as Cucumber makes it easy to read and to understand the application flow.

Cucumber tool is based on the Behavior Driven Development framework that acts as the bridge between the following people:

- Software Engineer and Business Analyst.
- Manual Tester and Automation Tester.
- Manual Tester and Developers.

Cucumber also benefits the client to understand the application code as it uses Gherkin language which is in Plain Text. Anyone in the organization can understand the behavior of the software. The syntax's of Gherkin is in simple text which is readable and understandable.

Gherkin is designed to be easy to learn by non-programmers, yet structured enough to allow concise description of examples to illustrate business rules in most real-world domains.

For more, read documentation:
[Cucumber documentation](https://docs.cucumber.io/)


### Selenium Grid

By raising Selenium Gid, it will be much easier to perform automatic tests on different environments and search engines, depending on the needs of the projects.

It will also be possible to run parallel automated tests which will lead to time and resource saving on the local machine.

How to do this, we need to setup HUB and NODE on virtual machine that we will use for parallel automated tests.

Commands for build-up HUB or NODE:
```sh
sc create hub-selenium binpath= C:\tools\selenium-grid\3.6.0\service-hub-selenium\hub-selenium.exe
sc create node-chrome binpath= C:\tools\selenium-grid\3.6.0\service-node-chrome\node-chrome.exe
sc create node-firefox binpath= C:\tools\selenium-grid\3.6.0\service-node-firefox\node-firefox.exe
sc create node-internet-edge binpath= C:\tools\selenium-grid\3.6.0\service-node-edge\node-edge.exe
```

For more, read documentation:
[Selenium Grid documentation](https://www.seleniumhq.org/docs/07_selenium_grid.jsp)

We need to specified in config.properties file to setup the following parameters:
```sh
Environment URL for example (environment-hub-url = http://qa-tools.gecko.rs:4444/wd/hub)
Browser for example (select-browser-type = CHROME)
Operating system for example (select-os-type = LINUX)
Activate Selenium Grid logic (selenium-grid-active = true)
```

### Run automatic test

We can run this automatic test on local machine or you can use Selenium Grid to run test on virtual machines.

Open your favorite Terminal and run these commands.

Command for execution:
```sh
mvn clean -Dtest=RunnersScenarioStepDefinition verify
```
