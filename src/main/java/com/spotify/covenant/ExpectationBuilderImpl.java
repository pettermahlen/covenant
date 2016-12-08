package com.spotify.covenant;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO: document!
 * TODO: collapse with interface? No - unit tests shouldn't have to know about the 'T' parameter,
 * so should only know about the ExpectationBuilder interface.
 */
public class ExpectationBuilderImpl<R, T extends Consumer<Supplier<R>>>
    implements ExpectationBuilder<R> {

  private final T methodInvocationStub;

  public ExpectationBuilderImpl(T methodInvocationStub) {
    this.methodInvocationStub = methodInvocationStub;
  }

  // ideas
  // void then(Runnable) => execute side effects
  // void then(Consumer<Arguments>) => side effects based on args
  // void thenReturn(Function<Arguments, T>) => return value based on args
  // - Arguments should not be a class, but an actual argument list!?!
  @Override
  public void thenReturn(Supplier<R> result) {
    methodInvocationStub.accept(result);
  }

  @Override
  public void thenThrow(Throwable throwable) {
    // TODO: figure this one out - it's unlikely that you'll want to specify this in the sense of
    // an expectation. generally, exceptions should be exceptional? Or it could be something like
    // saying, "you shouldn't have this data at this point, and therefore throw an exception"
  }
}
