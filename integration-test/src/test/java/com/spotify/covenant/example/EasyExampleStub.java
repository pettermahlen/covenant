package com.spotify.covenant.example;

import com.spotify.covenant.ExpectationBuilder;
import com.spotify.covenant.ExpectationBuilderImpl;
import com.spotify.covenant.NoMatchingInvocationException;
import com.spotify.covenant.Recorder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.hamcrest.Matcher;

/**
 * Sketching out what the generated code might/should look like
 */
public class EasyExampleStub implements EasyExample {

  private final List<Method1InvocationStub> method1InvocationStubs = new CopyOnWriteArrayList<>();
  private final List<AnotherMethodInvocationStub> anotherMethodInvocationStubs = new CopyOnWriteArrayList<>();

  private final Recorder recorder;

  public EasyExampleStub(Recorder recorder) {
    this.recorder = recorder;
  }

  @Override
  public String method1(String arg1, int arg2) {
    for (Method1InvocationStub stub : method1InvocationStubs) {
      if (stub.arg1Matcher.matches(arg1) && stub.arg2Matcher.matches(arg2)) {
        String result = stub.responseSupplier.get();
        recorder.recordInvocation(EasyExample.class.getName(), "method1", result,
            arg1, arg2);
        return result;
      }
    }

    throw new NoMatchingInvocationException();
  }

  @Override
  public List<String> anotherMethod(List<String> inputs) {
    for (AnotherMethodInvocationStub stub : anotherMethodInvocationStubs) {
      if (stub.inputsMatcher.matches(inputs)) {
        List<String> result = stub.responseSupplier.get();
        recorder.recordInvocation(EasyExample.class.getName(), "anotherMethod", result, inputs);
        return result;
      }
    }

    throw new NoMatchingInvocationException();
  }

  public ExpectationBuilder<String> whenMethod1(Matcher<String> arg1Matcher, Matcher<Integer> arg2Matcher) {
    return new ExpectationBuilderImpl<>(new Method1InvocationStub(arg1Matcher, arg2Matcher));
  }

  public ExpectationBuilder<List<String>> whenAnotherMethod(Matcher<List<String>> inputsMatcher) {
    return new ExpectationBuilderImpl<>(new AnotherMethodInvocationStub(inputsMatcher));
  }

  private class Method1InvocationStub implements Consumer<Supplier<String>> {
    private final Matcher<String> arg1Matcher;
    private final Matcher<Integer> arg2Matcher;
    private Supplier<String> responseSupplier;

    private Method1InvocationStub(Matcher<String> arg1Matcher, Matcher<Integer> arg2Matcher) {
      this.arg1Matcher = arg1Matcher;
      this.arg2Matcher = arg2Matcher;
    }

    @Override
    public void accept(Supplier<String> stringSupplier) {
      this.responseSupplier = stringSupplier;
      method1InvocationStubs.add(this);
    }
  }

  private class AnotherMethodInvocationStub implements Consumer<Supplier<List<String>>> {
    private final Matcher<List<String>> inputsMatcher;
    private Supplier<List<String>> responseSupplier;

    private AnotherMethodInvocationStub(Matcher<List<String>> inputsMatcher) {
      this.inputsMatcher = inputsMatcher;
    }

    @Override
    public void accept(Supplier<List<String>> result) {
      responseSupplier = result;
      anotherMethodInvocationStubs.add(this);
    }
  }
}
