package com.Study.day1;

import org.testng.annotations.*;

public class TestngDemo1 {
    @Test
    public void  testCase1(){
        System.out.println("这是@test注解1.");
    }
    @Test
    public void  testCase2(){
        System.out.println("这是@test注解2.");
    }
    @Test
    public void aestCase3(){
        System.out.println("这是@test注解3.");
    }
    @BeforeTest
    public void  beforeTest1(){
        System.out.println("这是BeforeTest注解.");
    }
    @BeforeMethod
    public void  beforeTest2(){
        System.out.println("这是BeforeMethod注解.");
    }
    @AfterMethod
    public void  afterCase1(){
        System.out.println("这是AfterMethod注解.");
    }
    @AfterTest
    public void  afterCase2(){
        System.out.println("这是AfterTest注解.");
    }
}
