package com.spotify.covenant.example;

import static java.util.Collections.singletonList;

import java.util.List;

/**
 * TODO: document!
 */
public class UsesEasyExample {

  private final EasyExample example;

  public UsesEasyExample(EasyExample example) {
    this.example = example;
  }

  public List<String> doSomething(String string, int times) {
    String first = example.method1(string, times);

    return example.anotherMethod(singletonList(first));
  }
}
