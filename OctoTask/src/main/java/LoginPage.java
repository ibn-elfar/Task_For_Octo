import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@name=\"uid\"]")
    WebElement username;

    @FindBy (xpath = "//input[@name=\"password\"]")
    WebElement password;

    @FindBy (xpath = "//input[@name=\"btnLogin\"]")
    WebElement lgoinbtn;

    public void Login(String usr, String pass){

        username.sendKeys(usr);
        password.sendKeys(pass);
        lgoinbtn.click();
    }


}
