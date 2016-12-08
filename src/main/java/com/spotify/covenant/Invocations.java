package com.spotify.covenant;

import com.google.auto.value.AutoValue;
import java.lang.reflect.Method;
import java.util.List;

/**
 * TODO: document!
 */
public class Invocations {

  public static Object invoke(Object target, String methodName, List<Object> args) throws Exception {
    Method method = findMethod(target.getClass(), methodName, args);

    return method.invoke(target, args.toArray());
  }

  private static Method findMethod(Class<?> aClass, String methodName, List<Object> args) {
    // this is not a great implementation, but making it great is hard, so I'll tackle that later.

    for (Method method : aClass.getMethods()) {
      if (method.getName().equals(methodName) && method.getParameterCount() == args.size()) {
        return method;
      }
    }

    throw new IllegalStateException("No method found in class " + aClass + " with name '" + methodName + "' and arguments " + args);
  }

  public static Invocation create(String module, String methodName, Object result,
                                  List<Object> args) {
    return new AutoValue_Invocations_InvocationValue(module, methodName, result, args);
  }

  @AutoValue
  protected static abstract class InvocationValue implements Invocation {

  }
}
