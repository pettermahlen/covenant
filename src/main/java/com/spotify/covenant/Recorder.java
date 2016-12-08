package com.spotify.covenant;

/**
 * TODO: document!
 */
public interface Recorder {

  void recordInvocation(String moduleName, String methodName, Object result, Object... args);
}
