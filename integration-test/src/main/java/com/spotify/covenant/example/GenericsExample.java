package com.spotify.covenant.example;

import java.util.List;

/**
 * TODO: document!
 */
public interface GenericsExample<T> {
  // making it harder!
  List<T> usingClassTypeParameter(Class<T> klazz);
  <U> List<U> withMethodTypeParameter(Class<T> klazz);
}
