import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class CustomerPage extends PageBase{
    public CustomerPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name=\"uid\"]")
    WebElement username;

    @FindBy (xpath = "//input[@name=\"password\"]")
    WebElement password;

    @FindBy (xpath = "//input[@name=\"btnLogin\"]")
    WebElement lgoinbtn;

    @FindBy (xpath = "//a[@href =\"addcustomerpage.php\"]")
    WebElement newcustomer;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    WebElement customername;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    WebElement male;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    WebElement female;

    @FindBy (xpath = "//*[@id=\"dob\"]")
    WebElement date;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
    WebElement address;

    @FindBy (xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
    WebElement city;

    @FindBy (xpath = "//input[@name=\"state\"]")
    WebElement state;

    @FindBy (xpath = "//input[@name=\"pinno\"]")
    WebElement pin;

    @FindBy (xpath = "//input[@name=\"telephoneno\"]")
    WebElement mobilenumber;

    @FindBy (xpath = "//input[@name=\"emailid\"]")
    WebElement email;

    @FindBy (xpath = "//input[@name=\"password\"]")
    WebElement customerpassword;

    @FindBy (xpath = "//input[@name=\"sub\"]")
    WebElement submit;

    public void Login(String usr, String pass){

        username.sendKeys(usr);
        password.sendKeys(pass);
        lgoinbtn.click();
    }

    public void CustomerData(String cusname, String daate,String addr, String cityy, String statte, String pinn,
                             String num, String e_mail, String passow){

        newcustomer.click();
        customername.sendKeys(cusname);
        male.click();
        date.sendKeys(daate);
        address.sendKeys(addr);
        city.sendKeys(cityy);
        state.sendKeys(statte);
        pin.sendKeys(pinn);
        mobilenumber.sendKeys(num);
        email.sendKeys(e_mail);
        customerpassword.sendKeys(passow);
        submit.click();




    }


}
