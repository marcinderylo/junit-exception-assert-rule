package com.blogspot.nurkiewicz.junit.exceptionassert;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ExceptionAssertTest.class, WhenExceptionAssertIsNotSatisfiedTest.class})
public class TestSuite {

}
