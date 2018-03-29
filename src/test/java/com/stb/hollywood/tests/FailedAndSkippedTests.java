package com.stb.hollywood.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedAndSkippedTests {

    @Test(dependsOnMethods = {"testFailed"} )
    public void testSkipped(){
        System.out.println("Ignored");
    }

    @Test
    public void testFailed(){
        Assert.fail("The failed test");
    }
}
