package PageObjectTest;

import PageObjectFactory.Login;
import Utils.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseClass
{
//    AndroidDriver driver;
//    public LoginTest(AndroidDriver driver)
//    {
//        this.driver=driver;
//    }

    @Test(priority = 1)
            public void Registration() throws InterruptedException
            {
        //            Login login = new Login(driver);
                    String invalid_phone_no = "234@654!15";
                    driver.findElement(By.className("android.widget.EditText")).sendKeys(invalid_phone_no);
        //            login.enterPhoneno(invalid_phone_no);

        //            driver.findElement(By.className("android.widget.EditText")).sendKeys(invalid_phone_no);
                    String invalid_Toast_msg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
                    Assert.assertEquals(invalid_Toast_msg, "Enter valid number");
                    Thread.sleep(5000);
                    WebElement Phone_no_element = (WebElement) driver.findElement(By.className("android.widget.EditText"));
                    Phone_no_element.clear();   // clear the entered text

                    String valid_phone_no = "2345654340";
                    String OTP = "111111";
                    driver.findElement(By.className("android.widget.EditText")).sendKeys(valid_phone_no);
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Send OTP']")).click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));                                      //wait until page is loaded
                    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.TextView[1][@text='OTP Verification']")), "text", "OTP Verification"));
                    driver.findElement(By.className("android.widget.EditText")).sendKeys(OTP);
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Submit']")).click();                          //xpath with text

            }
            @Test(priority = 2)
                public void Access_Permissions() throws InterruptedException
                {
                        //Permissions
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));                                      //wait until page is loaded
                    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[1][@text='Permissions']")), "text", "Permissions"));
                    driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.ImageView[2]")).click();
                    driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.ImageView[2]")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.widget.ImageView[2]")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[4]//child::android.widget.ImageView[2]")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.ImageView[2]")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[6]//child::android.widget.ImageView[2]")).click();
                        driver.findElement(By.className("android.widget.CheckBox")).click();
                        driver.findElement(By.xpath("//android.widget.TextView[@text='I Agree']")).click();
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();                  //pictures(only this time)
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_coarse")).click();         //approximate location
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.id("android:id/button1")).click();                                                    //permissions button
                        driver.findElement(By.xpath("//android.widget.TextView[@text='I Agree']")).click();
                        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
                        Location location = driver.location();
                        System.out.print(location);
                }
                @Test(priority = 3)
                        public void FillForm() throws InterruptedException
          {
                        //Tell us about yourself
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));                                      //wait until page is loaded
              wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[1][@text='Tell us about yourself']")), "text", "Tell us about yourself"));
                        String name = "Rowling";
                        driver.findElement(By.xpath("//android.widget.EditText[@text='Full name']")).sendKeys(name);
        //            WebElement name_element = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.EditText"));
        //            name_element.clear();   // clear the entered text


                        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.EditText")).sendKeys("validemail@gmail.com");
                        driver.findElement(By.xpath("//android.view.ViewGroup[3]")).click();                                        //DOB
                        Thread.sleep(2000);
        //            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
        //                    ".scrollIntoView(text(\"August\"));"));
        //            String month = "April";                                                                                     //
                        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.NumberPicker[1]//child::android.widget.EditText[@text='January']")).isDisplayed());
        //            String month = "August";
        //            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\""+month+"\"));"));
        //            driver.findElement(By.xpath("//android.widget.LinearLayout//child::android.widget.NumberPicker[1]//child::android.widget.EditText[@text=\""+month+"\"]")).click();

                        WebElement month = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).setMaxSearchSwipes(2)" +
                                        ".scrollIntoView(new UiSelector().text(\"September\"))"));
                        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"September\").instance(0))")));
                        WebElement Date = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true).instance(1)).setMaxSearchSwipes(3)" +
                                        ".scrollIntoView(new UiSelector().text(\"26\"))"));
        //            driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(new UiSelector().textContains(\"5\").instance(1))")));
                        WebElement element = driver.findElement(By.xpath("//android.widget.NumberPicker[3]"));
                        Thread.sleep(2000);
        //            SwipeAction(element, "Up");
                        WebElement year = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true).instance(2)).setMaxSearchSwipes(3)" +
                                        ".scrollIntoView(new UiSelector().text(\"1994\"))"));
        //            driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector().scrollable(true).instance(2)).scrollIntoView(new UiSelector().textContains(\"1997\").instance(2))")));

                        driver.findElement(By.id("android:id/button1")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[4]//child::android.widget.ImageView")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//android.view.ViewGroup[2]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//android.view.ViewGroup[4]//child::android.widget.ImageView")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//android.view.ViewGroup[1]")).click();
                        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.EditText")).sendKeys("12, HSR Layout, Bengaluru");
                        driver.findElement(By.xpath("//android.view.ViewGroup[6]//child::android.widget.ImageView")).click();
                        String selecting_state = "New York";
                        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + selecting_state + "\"));"));
                        driver.findElement(By.xpath("//android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup//child::android.widget.TextView[@text=\"" + selecting_state + "\"]")).click();

                        driver.findElement(By.xpath("//android.view.ViewGroup[7]//child::android.widget.EditText")).sendKeys("56010");
                        WebElement montly_salary = driver.findElement(By.className("android.widget.ScrollView"));
                        SwipeAction(montly_salary, "Up");
                        driver.findElement(By.xpath("//android.view.ViewGroup[8]//child::android.widget.EditText")).sendKeys("Cooking");
                        driver.findElement(By.xpath("//android.view.ViewGroup[9]//child::android.widget.EditText")).sendKeys("7894");
                        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.TextView")).click();
        //            Thread.sleep(5000);
        //            String value = ""
        //            Assert.assertEquals(driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[@text='Next']")).getAttribute("enabled"),"True");
                        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[@text='Next']")).click();

        }
        @Test(priority = 4)
        public void GMailAccess() throws InterruptedException
                {
                        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait1.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[1][@text='Google account access']")), "text", "Google account access"));
                        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.CheckBox")).click();
//                        driver.findElement(By.xpath("//android.view.ViewGroup[2]")).click();                                               //Giving gmail access
                        Thread.sleep(5000);
                }

        }
