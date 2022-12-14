package Utilities;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static Utils.BaseClass.driver;

public class ScreenshotClass {
    int number = 0;
    public String getScreenShotFail(String testCaseName, AppiumDriver driver) throws IOException
    {
        String filename="FailedScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"//reports"+filename);
        FileUtils.copyFile(src,des);
        number+=1;
        return des;
    }
    public void getScreenShotPass() throws IOException
    {
        String filename="PassScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"/PassedScreenshot/"+filename);
        FileUtils.copyFile(src,des);
        number+=1;
    }


}
