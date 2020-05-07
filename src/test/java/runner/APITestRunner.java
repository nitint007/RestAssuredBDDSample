/**
 * 
 */
package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

/**
 * @author nitinthite
 *
 */
/*
 * PLZ read "https://docs.cucumber.io/cucumber/api/#running-cucumber" for more
 * details on cucumber options
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber/report.html",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports"},
features = "src/test/resources/features", 
tags = {"@e2e"},
glue = "stepdefinitions", 
monochrome = true,
strict = false)

/*
 * The first point which triggers the automation suite selected
 */
public class APITestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}
