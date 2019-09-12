package com.Study.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngDemo02 {
    //校验a==a
    @Test
    public void assertEqualTest(){
        String a="abcd";
        String b="abcde";
        Assert.assertEquals(a,b);
    }
    @Test
    public void assertnotEqualTest(){
        String a="abcd";
        String b="abcde";
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assernullTest(){
        String a="";
        Assert.assertNull(a);
    }
    @Test
    public void assertnotNullTest(){
        String a="";
        Assert.assertNotNull(a);
    }
}
