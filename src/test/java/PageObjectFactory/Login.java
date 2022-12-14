package PageObjectFactory;

import Actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends AndroidActions {
    AndroidDriver driver;

    public Login(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement phone_no_Field;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    private WebElement invalid_Phone_no_Toast_Msg;

    public void enterPhoneno(String phone_no)
    {
        phone_no_Field.sendKeys(phone_no);
    }

    public void toastMsg()
    {
        invalid_Phone_no_Toast_Msg.getAttribute("name");
//        return 0;
//        Assert.assertEquals(invalid_Toast_msg,"Enter valid number");
    }
}
