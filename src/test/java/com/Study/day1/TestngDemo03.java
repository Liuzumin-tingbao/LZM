package com.Study.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngDemo03 {
    //默认安装的firefox
    @Test
    public void openFirefoxTest1(){
        WebDriver wb=new FirefoxDriver();
    }
    //非默认安装的firefox
    @Test
    public void openFireFoxTest2(){
        System.setProperty("webdriver.firefox.driver","E:\\IDEAProject\\drivers\\geckodriver.exe");
        WebDriver wb=new FirefoxDriver();
        wb.quit();
    }
    //case：
    //打开游览器，进入百度，等待3s，后退页面，等待3s，退出
    @Test
    public void openChrometest1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        WebDriver wb=new ChromeDriver();
        wb.get("https://www.baidu.com");
        Thread.sleep(3000);
        wb.navigate().back();
        Thread.sleep(3000);
        wb.quit();
    }
    //case：
    //打开游览器，进入百度，等待3s，刷新页面，等待3s，退出
    @Test
    public void openChrometest2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        WebDriver wb=new ChromeDriver();
        wb.get("https://www.google.com");
        Thread.sleep(3000);
        wb.navigate().refresh();
        Thread.sleep(3000);
        wb.quit();
    }
    //case
    //打开游览器，进入百度，等待1s，设置游览器大小，游览器最大化，等待2s，获取url，校验是否为百度首页，关闭。
    @Test
    public void openChrometest3() throws InterruptedException {
        //设置driver路径
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        //实例化一个ChromeDriver
        WebDriver wb=new ChromeDriver();
        //打开百度页面
        wb.get("https://www.baidu.com");
        //设置页面大小,实例化dimension
        Dimension d=new Dimension(400,500);
        Thread.sleep(2000);
        //最大化页面
        wb.manage().window().maximize();
        //等待2秒
        Thread.sleep(2000);
        //获取当前页面的url
        String b=wb.getCurrentUrl();
        //校验是否为百度
        Assert.assertEquals(b,"https://www.baidu.com/");
        //获取页面的title
        String a=wb.getTitle();
        System.out.println(a);
        Thread.sleep(1000);
        //关闭
        wb.quit();
    }
}
