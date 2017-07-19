package com.github.shmvanhouten.practice.testforstubbing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreeterTest {
//    @Mock
//    NameGetter nameGetter;


    @Test
    public void itShouldReturnAGreetingWithMockedName() throws Exception {

        NameGetter nameGetter = mock(NameGetter.class);
        Greeter greeter = new Greeter(nameGetter);
        when(greeter.greet(any(String.class))).thenReturn("Henk");
        String result = greeter.greet("Sjoerd");
        assertThat(result, is("Hello Henk"));
    }
}