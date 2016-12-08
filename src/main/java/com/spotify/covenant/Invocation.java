package com.spotify.covenant;

import java.util.List;

/**
 * TODO: document!
 */
public interface Invocation {

  String module();

  String method();

  Object result();

  List<Object> args();
}
