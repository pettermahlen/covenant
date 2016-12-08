package com.spotify.covenant;

import java.util.function.Supplier;

/**
 * TODO: document!
 */
public interface ExpectationBuilder<R> {

  // ideas
  // void then(Runnable) => execute side effects
  // void then(Consumer<Arguments>) => side effects based on args
  // void thenReturn(Function<Arguments, T>) => return value based on args
  // - Arguments should not be a class, but an actual argument list!?!
  void thenReturn(Supplier<R> result);

  void thenThrow(Throwable throwable);
}
