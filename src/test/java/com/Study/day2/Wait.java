package com.Study.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.concurrent.TimeUnit;

public class Wait {
    WebDriver wb;
    @BeforeMethod
    public void OpenChrome1(){
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
        //全局等待；
//      wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void Wait1() {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement unn = wb.findElement(By.xpath("//*[@id=\"wait\"]/input"));
        unn.click();
        //显示等待；
//      WebElement unt = new WebDriverWait(wb, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wait\"]/input")));
        WebDriverWait waiter = new WebDriverWait(wb,10);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String a = wb.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(a,"wait for display");
    }
    @AfterMethod
    public void Closed(){
        wb.quit();
    }
}
