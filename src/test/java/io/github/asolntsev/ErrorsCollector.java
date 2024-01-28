package io.github.asolntsev;

import static java.lang.ThreadLocal.withInitial;

import java.util.ArrayList;
import java.util.List;

public class ErrorsCollector {
  private static final ThreadLocal<List<String>> errors = withInitial(ArrayList::new);

  public static void reset() {
    errors.remove();
  }

  public static List<String> getErrors() {
    return errors.get();
  }

  public static void addError(String error) {
    errors.get().add(error);
  }

}
