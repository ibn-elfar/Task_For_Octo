import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class CustomerTest extends TestBase{
    CustomerPage customerPage;

    @Test (priority=1)
    public void AddingValidData() throws InterruptedException {
        customerPage = new CustomerPage(driver);
        customerPage.Login("mngr461159", "unyzarY");
        customerPage.CustomerData("ahmed mohamed","10/05/1999","Egypt",
                "Dilingat","Behira","555655","01014254896",
                "ahmed_mhmd20@outlook.com","hgbNb458");

        String actual = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
        String expected= "Customer Registered Successfully!!!";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(2000);
        driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");

    }

    @Test (priority=2)
    public void UsedEmail() throws InterruptedException {
        //customerPage = new CustomerPage(driver);
        //customerPage.Login("mngr461159", "unyzarY");
        customerPage.CustomerData("ahmed mohamed","10/05/1999","Egypt",
                "Dilingat","Behira","555655","01014254896",
                "ahmedmo5875@outlook.com","hgbNb458");

        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected= "Email Address Already Exist !!";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(2000);
        alert.accept();

    }

    @Test (priority=3 )
    public void NullCustomerName() throws InterruptedException {
        //customerPage = new CustomerPage(driver);
        //customerPage.Login("mngr461159", "unyzarY");
        customerPage.CustomerData("","10/05/1999","Egypt",
                "Dilingat","Behira","555655","01014254896",
                "ahmedmo57275@outlook.com","hgbNb458");

        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected= "please fill all fields";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(2000);
        alert.accept();
        //driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
    }


}
