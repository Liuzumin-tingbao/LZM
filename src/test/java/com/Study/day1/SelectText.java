package com.Study.day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SelectText {
    WebDriver wb;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
    }
    @AfterMethod
    public void closedriver(){
        wb.quit();
    }
    @Test
//1. 打开“UI 自动化测试”主页
//2. 点击Alert 按钮
//3. 在alert警告框点击确认
    public void openChrome() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = wb.switchTo().alert();
        alert.accept();
    }
    @Test
//1. 打开“UI 自动化测试”主页
//2. 点击Confirm 按钮
//3. 在Confirm 警告 框点击 确定
    public void openChrome1() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(2000);
        Alert alert = wb.switchTo().alert();
        alert.accept();
    }
    @Test
//1. 打开“UI 自动化测试”主页
//2. 点击Prompt 按钮
//3. 在Prompt 弹窗中，输入“这个是Prompt” ”
//4. 点击确定
    public void openChrome2() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
        Alert prompt = wb.switchTo().alert();
        prompt.sendKeys("这个是Prompt");//chrome浏览器bug，sedkeys的值写入不了prompt；
        Thread.sleep(5000);
        prompt.accept();
    }
    @Test
//1. 定位iFrame
//2. driver 控制权交给iFrame,通过frame的name转交权限
//3. 操作iFrame 里面的元素
//4. driver 控制权交回原页面
    public void findiFrame() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.switchTo().frame("aa");
        wb.findElement(By.id("user")).sendKeys("wo ai ting bao");
        Thread.sleep(4000);
        wb.switchTo().defaultContent();
    }
    @Test
//1. selectByIndex() 根据索引来选取，从0开始
//2. selectByValue() 根据属性value的属性值来选取
//3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
    public void select() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = wb.findElement(By.id("moreSelect"));
        Select select = new Select(element);
        select.selectByIndex(2);
        Thread.sleep(5000);
        select.selectByValue("oppe");
        Thread.sleep(5000);
        select.selectByVisibleText("iphone");
        Thread.sleep(5000);
    }
    @Test
//多窗口的处理
    public void windows() throws InterruptedException {
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.findElement(By.xpath("//*[@id=\"open\"]/a")).click();
        String handle = wb.getWindowHandle();
        for(String handles:wb.getWindowHandles()){
            if(handles.endsWith(handle)){
                continue;
            }
            wb.switchTo().window(handles);
        }
        Thread.sleep(5000);
        wb.findElement(By.id("user")).sendKeys("tingbaobao1");
        Thread.sleep(5000);
        wb.close();
        wb.switchTo().window(handle);
        wb.findElement(By.id("user")).sendKeys("tingbaobao2");
        Thread.sleep(5000);
    }
    @Test
//1. 打开百度首页
//2. 点击百度首页的“糯米”链接。
    public void openBaidu(){
        wb.get("https://www.baidu.com");
        WebElement element = wb.findElement(By.name("tj_trnews"));
        element.click();
    }
    @Test
//1. 打开百度页面
//2. 在搜索文本框输入selenium
//3. 点击百度一下按钮
    public void writeText() throws InterruptedException {
        wb.get("https://www.baidu.com");
        wb.findElement(By.id("kw")).sendKeys("selenium");
        wb.findElement(By.id("su")).click();
        Thread.sleep(2000);
        wb.findElement(By.id("kw")).clear();
        Thread.sleep(3000);
    }
    @Test
//1. 打开百度首页
//2. 获取右上角所有的文本并输出
    public void getText() throws InterruptedException {
        wb.get("https://www.baidu.com");
        List<WebElement> elements = wb.findElements(By.xpath("//*[@id=\"u1\"]"));
        for(int i=0;i<elements.size();i++){
            String text = elements.get(i).getText();
            System.out.print(text);
        }
        Thread.sleep(3000);
    }
    @Test
//1. 打开百度首页
//2. 获取搜索框的TagName
    public void getTagname(){
        wb.get("https://www.baidu.com");
        WebElement ele = wb.findElement(By.id("kw"));
        String a = ele.getTagName();
        System.out.println(a);
    }
    @Test
//1. 打开百度首页
////2. 搜索框输入“webdriver”
////3. 获取搜索框的 value 属性值
    public void getValue() throws InterruptedException{
        wb.get("https://www.baidu.com");
        wb.findElement(By.id("kw")).sendKeys("webdrivers");
        Thread.sleep(2000);
        String att = wb.findElement(By.id("kw")).getAttribute("value");
        System.out.println(att);
        Assert.assertEquals(att,"webdrivers");
    }
    @Test
//1. 打开百度首页
//2. 获取当前页面的title
//3. 校验title 值等于“百度一下，你就知道 ”
    public void getTitle(){
        wb.get("https://www.baidu.com");
        String a = wb.getTitle();
        Assert.assertEquals(a,"百度一下，你就知道");
    }
    @Test
//1. 打开百度首页
//2. 校验百度一下按钮已经展示
    public void disable(){
        wb.get("https://www.baidu.com");
        boolean a = wb.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(a,"校验百度按钮是否展示");
    }
    @Test
//1. 打开 “UI自动化测试”主页
//2. 校验 “Volvo”单选框已经选中
    public void selected(){
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        wb.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).click();
        boolean a = wb.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).isSelected();
        Assert.assertTrue(a,"校验Volvo已选中");
    }
    @Test
//1. 打开“UI自动化测试”主页
//2. 校验 submit 文本框为不可输入状态
    public void enable(){
        wb.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        boolean a = wb.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(a,"校验文本框是否为激活状态");
    }
    @Test
//1. 打开百度主页
//2. 截图
    public void png(){
        wb.get("https://www.baidu.com");
        //截图保存在桌面
        File ScreenShotfile =((TakesScreenshot) wb).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(ScreenShotfile,new File("C:\\Users\\Administrator\\Desktop\\test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}