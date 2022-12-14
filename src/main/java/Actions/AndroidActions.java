package Actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions {
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver)
    {
        this.driver=driver;
    }
    public void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down", "percent", 3.0));
        }
        while (canScrollMore);
    }

    public void SwipeAction(WebElement ele, String direction)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "direction", direction, "percent", 0.75));
    }
    public void scrollIntoView(String text)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\""+text+"\"));"));
    }

    public void DragandDropAction(WebElement ele, int X, int Y)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "endX", X, "endY", Y));
    }

    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public static String charRemoveAt(String string_change, int remove_char_at) {
        return string_change.substring(0, remove_char_at) + string_change.substring(remove_char_at + 1);
    }
}
