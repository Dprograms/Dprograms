package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utility.Driver_Class;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Takescreenshot {

	public TakesScreenshot driver = (TakesScreenshot) Driver_Class.setup();
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@AfterStep
	public void attachScreenshot() {
		this.scenario.attach(driver.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
	}

}