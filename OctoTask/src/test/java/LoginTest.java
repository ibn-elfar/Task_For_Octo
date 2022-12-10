import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage;

    @Test (priority=1)
     public void ValidLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Login("mngr461159", "unyzarY");
        String actual = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        String expected = "Manger Id : mngr461159";
        Assert.assertTrue(actual.contains(expected));
        WebElement logotbtn = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a"));
        logotbtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
    }

    @Test (priority=2)
    public void INValidUsername() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Login("mn461159", "unyzarY");
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "User or Password is not valid";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);
        alert.accept();


    }

    @Test (priority=3)
    public void INValidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Login("mngr461159", "uzarY");
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "User or Password is not valid";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);
        alert.accept();
    }

    @Test (priority=4)
    public void NullUsername() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Login("", "unyzarY");
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "User or Password is not valid";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);
        alert.accept();
    }

    @Test (priority=5)
    public void NullPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Login("mngr461159", "");
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "User or Password is not valid";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);
        alert.accept();
    }

}
