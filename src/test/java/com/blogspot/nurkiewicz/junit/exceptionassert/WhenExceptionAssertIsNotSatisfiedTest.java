package com.blogspot.nurkiewicz.junit.exceptionassert;

import com.blogspot.nurkiewicz.junit.UnderTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Marcin Deryło <marcinderylo@gmail.com>
 */
public class WhenExceptionAssertIsNotSatisfiedTest {
    @Test
    public void shouldThrowAssertionErrorWhenExceptionExpectedButNotThrown() throws Exception {
        Result result = JUnitCore.runClasses(ShouldThrowAssertionErrorWhenExceptionExpectedButNotThrownTestCase.class);
        assertEquals("failed tests count", 1, result.getFailureCount());
        assertThat(result.getFailures().get(0).getException(), instanceOf(AssertionError.class));
    }

    @Test
    public void shouldThrowOriginalExceptionIfNotExpected() throws Exception {
        Result result = JUnitCore.runClasses(ShouldThrowOriginalExceptionIfNotExpectedTestCase.class);
        assertEquals("failed tests count", 1, result.getFailureCount());
        assertThat(result.getFailures().get(0).getException(), instanceOf(IllegalArgumentException.class));
    }

    public static class ShouldThrowAssertionErrorWhenExceptionExpectedButNotThrownTestCase {

        @UnderTest
        private FooService fooService = new DefaultFooService();

        @Rule
        public ExceptionAssert exception = new ExceptionAssert();

        @Test
        public void failingTest() throws Exception {
            //given
            String name = "James";

            //when
            final String result = fooService.echo(name);

            //then
            exception.expect(IllegalArgumentException.class);
        }
    }

    public static class ShouldThrowOriginalExceptionIfNotExpectedTestCase {
        @UnderTest
        private FooService fooService = new DefaultFooService();

        @Rule
        public ExceptionAssert exception = new ExceptionAssert();


        @Test
        public void failingTest() throws Exception {
            //given
            String name = "John";

            //when
            final String result = fooService.echo(name);

            //then
            //exception not expected
        }
    }
}
