package com.webwalker.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//直接执行 
@RunWith(Suite.class)
@SuiteClasses({ TestWebServiceSample.class, CalculatorTest.class })
public class AllTests {

}
