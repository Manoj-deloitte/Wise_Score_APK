    package Utilities;


import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerForScreenshot extends ScreenshotClass implements ITestListener
{

    @Override
    public void onTestSuccess(ITestResult result)
    {
        try {
            getScreenShotPass();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            getScreenShotFail();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

