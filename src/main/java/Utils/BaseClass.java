package Utils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {

    public static AndroidDriver driver;
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
//        options.setApp("C:\\Users\\javvkumar\\IdeaProjects\\Mobile App\\src\\main\\resources\\ApiDemos-debug.apk");
        options.setApp("C:\\Users\\javvkumar\\IdeaProjects\\Wise_Score\\src\\main\\resources\\Wise_Score_3.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));         //Implicit Wait
    }
    public void SwipeAction(WebElement ele, String direction)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "direction", direction, "percent", 0.75));
    }
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//        //Stop the Appium Server
//        serviceBuilder.stop();
//    }
}
