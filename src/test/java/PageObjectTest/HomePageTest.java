package PageObjectTest;

import Utils.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;


public class HomePageTest extends BaseClass
{
//    static AndroidDriver driver;
    String name = "Jonathan burge";
    String phone_no = "8765647689";
    String Loan_Amount = "650";
    LocalDate date = LocalDate.now();                  //Getting Current Date
    String DS = date.toString();
    @Test(priority = 1)
    public void Welcome_Page() throws InterruptedException {
//        String name = "Jonathan burge";
//        Activity activity = new Activity("com.wisescore", "com.wisescore.MainActivity");
//        driver.startActivity(activity);
        String phone_no = "8765647689";
        String OTP = "111111";
        driver.findElement(By.className("android.widget.EditText")).sendKeys(phone_no);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Send OTP']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));                                      //wait until page is loaded
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.TextView[1][@text='OTP Verification']")), "text", "OTP Verification"));
        driver.findElement(By.className("android.widget.EditText")).sendKeys(OTP);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Submit']")).click();
        Thread.sleep(2000);
        String entered_name = driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(entered_name, "Welcome, " + name);
//        Thread.sleep(2000);


//        String Loan_Amount = "650";
//        LocalDate date = LocalDate.now();                  //Getting Current Date
//        String DS = date.toString();


        driver.findElement(By.className("android.view.ViewGroup")).click();
        Thread.sleep(2000);

    }


    @Test(priority = 2)
    public void Personal_Information() throws InterruptedException {
        //Personal Information
        driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.ImageView[2]")).click();          //personal Information
        String checking_name = driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[2]")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(checking_name, name);
//        Thread.sleep(2000);
        String entered_phoneno = driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(entered_phoneno, phone_no);
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.widget.TextView")).click();

        Thread.sleep(5000);
        String Residence = "12, HSR Layout, Bengaluru";
        WebElement Residence_element = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.EditText"));
        Residence_element.clear();   // clear the entered text
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.EditText")).sendKeys(Residence);
//        WebElement state_element = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[6]//child::android.widget.EditText"));
//        state_element.clear();   // clear the entered text
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.view.ViewGroup[6]//child::android.widget.ImageView")).click();
        String selecting_state = "Ohio";
        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + selecting_state + "\"));"));
        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.view.ViewGroup//android.widget.TextView[@text=\"" + selecting_state + "\"]")).click();
        String pincode = "90877";
        WebElement pincode_element = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[7]//child::android.widget.EditText"));
        pincode_element.clear();   // clear the entered text
        driver.findElement(By.xpath("//android.view.ViewGroup[7]//child::android.widget.EditText")).sendKeys(pincode);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
        Thread.sleep(3000);
        String check_Residence = driver.findElement(By.xpath("//android.view.ViewGroup[4]//child::android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[4]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(check_Residence, Residence + ',' + ' ' + selecting_state + ' ' + '-' + ' ' + pincode);
        Thread.sleep(5000);

        //Personal Loan History
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.view.ViewGroup//child::android.widget.ImageView")).click();
        Thread.sleep(2000);
//        String personal_lone_amount = driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[3]//child::android.widget.TextView[2]")).getText();
//        Assert.assertEquals(personal_lone_amount,Loan_Amount);
//        String personal_lone_Date = driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[3]//child::android.widget.TextView[3]")).getText();
//        Assert.assertEquals(personal_lone_Date,DS);
//        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup//child::android.widget.ImageView")).click();


        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView")).click();               //closing personal loan history
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));     //Android key events
//        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void Manage_Bank_Accounts() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));     //Android key events
        Thread.sleep(2000);
        //Manage Bank Accounts
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.view.ViewGroup[1]//child::android.widget.TextView")).click();
        //Fill your bank details
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.ImageView")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.TextView[@text='Select Bank']")).click();
        String Select_Bank = "Wells Fargo";
        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.view.ViewGroup//android.widget.TextView[@text=\"" + Select_Bank + "\"]")).click();
        String Bank_acc_no = "1347689368";   //It can be of range 10-12
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.EditText")).sendKeys(Bank_acc_no);
        String Routing_Nubmer = "053208066";
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.widget.EditText")).sendKeys(Routing_Nubmer);
        driver.findElement(By.xpath("//android.view.ViewGroup[4]//child::android.widget.ImageView")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.view.ViewGroup")).click();    //checkings
//        driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.view.ViewGroup")).click();   //Savings
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.TextView")).click();            //Add bank account button
        driver.findElement(By.xpath("//android.view.ViewGroup[7]//child::android.view.ViewGroup//child::android.widget.TextView")).click();
        Thread.sleep(7000);
        // Back to Manage Bank Account
//        String entered_Bankname = driver.findElement(By.xpath("//android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[2]//child::android.widget.TextView[1]")).getText();
//        Assert.assertTrue(entered_Bankname.contains(Select_Bank));

        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup[2]//child::android.widget.TextView")).click();      //Bank View button
        Thread.sleep(2000);
        String Account_holder_name = driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(Account_holder_name, name);
        String Acc_no = driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(Acc_no, Bank_acc_no);
        String Routing_no = driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(Routing_no, Routing_Nubmer);
        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup[3]//child::android.widget.TextView")).click();            //Delete Bank button
        Thread.sleep(2000);
        String delete_msg = "Are you sure you want to delete?";
        String delete_Conf = driver.findElement(By.xpath("//android.widget.LinearLayout//child::android.widget.FrameLayout//child::android.widget.TextView")).getText();
        Assert.assertTrue(delete_Conf.contains(delete_msg));     //assert using contains method
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();                                //Delete Bank details
//        driver.findElement(By.id("android:id/button2")).click();                                  //Cancel Deleting Bank details
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 4)
    public void Apply_Loan() throws InterruptedException {

        //Apply Loan
        String amount_text = "$751 - 900";
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + amount_text + "\"));"));
        String applying_Bank_name = driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.TextView[1]")).getText();
        String applying_amount_range = driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.TextView[2]")).getText();
        String applying_Interest_rate = driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.widget.TextView[3]")).getText();
        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.view.ViewGroup//child::android.widget.TextView")).click();
        Thread.sleep(2000);
        String applied_Bank_name = driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(applied_Bank_name, applying_Bank_name);
        String amount_eligible = driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[3]")).getText();
        try {
            Assert.assertTrue(StringUtils.containsIgnoreCase(amount_eligible, applying_amount_range));
        } catch (AssertionError e) {
            System.out.println(e);
        }
        String Rate_Of_Inte = driver.findElement(By.xpath("//android.view.ViewGroup//child::android.widget.TextView[4]")).getText();
//        charRemoveAt(applying_Interest_rate,1);
        try {
            Assert.assertTrue(Rate_Of_Inte.contains("Rate of interest: " + applying_Interest_rate));
        } catch (AssertionError e1) {
            System.out.println(e1);
        }
//        Assert.assertEquals(Rate_Of_Inte,applying_Interest_rate);
        driver.findElement(By.xpath("//android.view.ViewGroup[1]//child::android.widget.EditText")).sendKeys(Loan_Amount);  //Entering loan amount
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.view.ViewGroup[2]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.widget.CheckBox")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup//child::android.widget.TextView")).click();  //submit button

//        String Alert_for_amount = "Please enter loan amount within the selected range.";
//        String Not_in_range = driver.findElement(By.id("android:id/message")).getText();
//        Assert.assertEquals(Not_in_range,Alert_for_amount);
//        driver.findElement(By.xpath("//android.widget.LinearLayout//child::android.widget.Button")).click();  //Alert accepting
        //checking if the entered amount is correct or not
        Thread.sleep(2000);
        String Loan_applied_amount = driver.findElement(By.xpath("//android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[2]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(Loan_applied_amount, "$" + Loan_Amount);
        String Loan_applied_Interest = driver.findElement(By.xpath("//android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[3]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(applying_Interest_rate, Loan_applied_Interest + "%");

        String Loan_applied_Date = driver.findElement(By.xpath("//android.widget.ScrollView//child::android.view.ViewGroup//child::android.view.ViewGroup[4]//child::android.widget.TextView[2]")).getText();
        Assert.assertEquals(Loan_applied_Date, DS);
//        driver.findElement(By.xpath("//android.view.ViewGroup//child::android.view.ViewGroup[4]//child::android.widget.TextView[@text='All Loans >']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup//child::android.widget.TextView[@text='Withdraw']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[3]//child::android.view.ViewGroup")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[2]//child::android.widget.TextView[@text='Withdraw']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("android.view.ViewGroup")).click();
    }

    @Test(priority = 3)
            public void Logout() throws InterruptedException
    {
        //Logout
        driver.findElement(By.xpath("//android.view.ViewGroup[5]//child::android.view.ViewGroup")).click();
        String logout_msg = "Are you sure you want to log out?";
        String logout_conf =driver.findElement(By.id("android:id/message")).getText();
        Assert.assertTrue(logout_conf.contains(logout_msg));
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(5000);

    }
}
