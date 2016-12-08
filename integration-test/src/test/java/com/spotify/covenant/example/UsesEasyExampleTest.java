package com.spotify.covenant.example;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * TODO: document!
 */
public class UsesEasyExampleTest {
  UsesEasyExample sut;

  EasyExampleStub easyExampleStub;

  @Before
  public void setUp() throws Exception {
    easyExampleStub = new EasyExampleStub();

    sut = new UsesEasyExample(easyExampleStub);
  }

  @Test
  public void shouldBlah() throws Exception {
    easyExampleStub
        .whenMethod1(is("floop"), is(2))
        .thenReturn(() -> "gotcha");

    easyExampleStub
        .whenAnotherMethod(equalTo(singletonList("gotcha")))
        .thenReturn(() -> singletonList("flerbity"));

    assertThat(
        sut.doSomething("floop", 2),
        is(singletonList("flerbity")));
  }
}