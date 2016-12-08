package com.spotify.covenant.example;

import java.util.List;

/**
 * TODO: document!
 */
public class EasyProducer implements EasyExample {

  @Override
  public String method1(String arg1, int arg2) {
    if (arg1.equals("string") && arg2 == 5711) {
      return "floop";
    }

    return null;
  }

  @Override
  public List<String> anotherMethod(List<String> inputs) {
    return null;
  }
}
