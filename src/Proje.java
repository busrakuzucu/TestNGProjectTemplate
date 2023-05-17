import Utility.BaseDriverParameter;
import Utility.ProjePOM;
import Utility.Tools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Proje extends BaseDriverParameter {

    @Test
    void Test1() {
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    void Test2() {
        ProjePOM tcp = new ProjePOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        for (WebElement a : tcp.leftnavMenus) {
            a.click();
            Tools.bekle(1);
            for (WebElement b : tcp.underLeftnavMenus) {
                Assert.assertTrue(b.isDisplayed());
            }
        }

    }

    @Test
    void Test3() throws AWTException {
        Robot rbt = new Robot();
        ProjePOM tcp = new ProjePOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        tcp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tcp.addNewCustomer));
        tcp.addNewCustomer.click();
        wait.until(ExpectedConditions.visibilityOf(tcp.emailBox));
        tcp.emailBox.sendKeys("busra@gmail.com");
        tcp.passwordBox.sendKeys("group10");
        tcp.firstNameBox.sendKeys("Busra");
        tcp.lastNameBox.sendKeys("Unlu");
        tcp.maleCheckbox.click();
        tcp.birthDate.sendKeys("13/08/1994");
        tcp.companyName.sendKeys("group");
        tcp.taxExemptBox.click();
        tcp.newsLetter.click();
        rbt.keyPress(KeyEvent.VK_DOWN);
        rbt.keyRelease(KeyEvent.VK_DOWN);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
        Select vendor = new Select(tcp.vendorSelect);
        vendor.selectByIndex(1);
        tcp.commentBox.sendKeys("group");
        tcp.saveButton.click();
        Assert.assertTrue(tcp.successMsg.getText().contains("successfully"));
    }

    @Test
    void Test4() {
        ProjePOM tcp = new ProjePOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        tcp.underLeftnavMenus.get(0).click();
        tcp.searchEmail.sendKeys("busra@gmail.com");
        tcp.searchFirstName.sendKeys("Busra");
        tcp.searchLastName.sendKeys("Unlu");
        tcp.customerSearchBtn.click();
        Assert.assertTrue(tcp.customerMailSearchResult.getText().contains("busra@gmail.com"));
    }

    @Test
    void Test5() {
        ProjePOM tcp = new ProjePOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        tcp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tcp.searchEmail));
        tcp.searchEmail.sendKeys("busra@gmail.com");
        tcp.searchFirstName.sendKeys("Busra");
        tcp.searchLastName.sendKeys("Unlu");
        tcp.customerSearchBtn.click();
        tcp.editBtn.click();
        wait.until(ExpectedConditions.visibilityOf(tcp.customerDeleteBtn));
        tcp.customerDeleteBtn.click();
        tcp.customerDeleteBtn2.click();
        Assert.assertTrue(tcp.successMsg.getText().contains("successfully"));
    }



}
