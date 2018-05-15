package com.mock.test;

import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mock.controller.MockContrller;

public class NewTest {
	private final static Logger log = LogManager.getLogger(NewTest.class);
	@Test
	public void firstTestCase() throws InterruptedException {
		MockContrller test = new MockContrller();
		System.out.println(test.getWeixinCustRepayInfo());
    }
	@Test
	public void runOtherTest1() {
		 System.out.println("@Test - runOtherTest1");
	}

	@Test
	public void runOtherTest2() {
	     System.out.println("@Test - runOtherTest2");
	}
}
