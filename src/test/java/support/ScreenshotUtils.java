package support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static run.RunBase.getDriver;

public class ScreenshotUtils {

    public static void addScreenshot(Scenario scenario){
        byte[]  screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Foto do erro");
    }
}
