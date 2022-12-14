package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserClass {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //Staring the Appium Server
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\javvkumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();

        //Giving the phone and app details to the UIAUTOMATOR2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Test_Emulator");
        //Chrome driver
//        options.setChromedriverExecutable("C:\\Users\\javvkumar\\Downloads\\chromedriver.exe");
//        options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));         //Implicit Wait
    }
    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
        //Stop the Appium Server
        serviceBuilder.stop();
    }
}