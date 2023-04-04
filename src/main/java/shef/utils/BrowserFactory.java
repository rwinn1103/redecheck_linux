package shef.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
//import selenium.webdriver.firefox.options;
import org.openqa.selenium.firefox.FirefoxOptions;
//import com.google.common.collect;

import java.io.IOException;

/**
 * Created by thomaswalsh on 03/04/2017.
 */
public class BrowserFactory {

    public static WebDriver getNewDriver(String browser) throws IOException {
        WebDriver webDriver = null;
        // Set up the web driver depending on the browser being used.
        if (browser.equals("firefox")) {
            DesiredCapabilities Tcap = new DesiredCapabilities().firefox();
            Tcap.setCapability("marionette", false);
            Tcap.setCapability("headless", true);
            Tcap.setCapability("browser.headless", true);
            //Tcap.setCapability("moz:firefoxOptions.args", "--headless");
            //Tcap["headless"] = true;
            //Tcap.setHeadless(true);
            FirefoxOptions options = new FirefoxOptions();
            //options.setHeadless(true);
            options.addArguments("--headless");
            Tcap.setCapability("moz:firefoxOptions", options);
            //Tcap.merge(options);
            //options.merge(Capabilities Tcap);
            //Tcap.setCapability(FirefoxOptions.CAPABILITY, options);
            webDriver = new FirefoxDriver(Tcap);
        } else if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            webDriver = new ChromeDriver(capabilities);
        } else if (browser.equals("phantom")) {
            DesiredCapabilities dCaps = new DesiredCapabilities();
            dCaps.setJavascriptEnabled(true);
            dCaps.setCapability("takesScreenshot", true);
            String current = new java.io.File( "." ).getCanonicalPath();
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, current + "/../resources/phantomjs");
//            String[] phantomArgs = new String[]{"--webdriver-loglevel=NONE"};
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
//            webDriver = new PhantomJSDriver(dCaps);
        } else if (browser.equals("opera")) {
            DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
            capabilities.setJavascriptEnabled(true);
            webDriver = new OperaDriver(capabilities);
        }
        return webDriver;
    }
}
