package com.Study.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FindElementDay06 {
    WebDriver wb;
    //查找页面元素id
    @Test
    public void OpenChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
        wb.get("https://www.baidu.com");
        Thread.sleep(3000);
        WebElement fileElement = wb.findElement(By.id("kw"));
        Thread.sleep(2000);
        wb.quit();
    }
    //查找页面元素name、class

    @Test
    public void findbyName1() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
        wb.get("https://www.baidu.com");
        Thread.sleep(3000);
        WebElement file = wb.findElement(By.name("tj_settingicon"));
        Thread.sleep(2000);
        wb.quit();
    }
    @Test
    public void findbyClass1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
        wb.get("https://www.baidu.com");
        Thread.sleep(3000);
        WebElement file = wb.findElement(By.className("mnav"));
        Thread.sleep(2000);
        wb.quit();
    }
}
