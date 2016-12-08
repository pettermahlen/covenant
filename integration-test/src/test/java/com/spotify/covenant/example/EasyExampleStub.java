package com.spotify.covenant.example;

import java.util.List;
import java.util.function.Supplier;
import org.hamcrest.Matcher;

/**
 * Sketching out what the generated code might/should look like
 */
public class EasyExampleStub implements EasyExample {

  @Override
  public String method1(String arg1, int arg2) {
    return null;
  }

  @Override
  public List<String> anotherMethod(List<String> inputs) {
    return null;
  }

  public ExpectationBuilder<String> whenMethod1(Matcher<String> arg1Matcher, Matcher<Integer> arg2Matcher) {
    return new ExpectationBuilder<>();
  }

  public ExpectationBuilder<List<String>> whenAnotherMethod(Matcher<List<String>> inputsMatcher) {
    return new ExpectationBuilder<>();
  }

  public class ExpectationBuilder<T> {
    // ideas
    // void then(Runnable) => execute side effects
    // void then(Consumer<Arguments>) => side effects based on args
    // void thenReturn(Function<Arguments, T>) => return value based on args
    // - Arguments should not be a class, but an actual argument list!?!

    void thenReturn(Supplier<T> result) {

    }

    void thenThrow(Throwable throwable) {

    }
  }
}
