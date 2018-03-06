package com.stb.hollywood.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectTest extends BaseTest{

    @Test
    public void test() {

        openHollywoodURL();
        Assert.assertEquals(0, 0);
        Assert.assertEquals(1,0);
    }
}
