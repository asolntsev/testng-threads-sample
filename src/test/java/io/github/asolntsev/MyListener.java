package io.github.asolntsev;

import static java.lang.Thread.currentThread;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
  private static final Logger log = LoggerFactory.getLogger(MyListener.class);

  @Override
  public void onTestStart(ITestResult result) {
    log.info("Before test {} in {}", result.getName(), currentThread().getName());
    ErrorsCollector.reset();
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info("After test {} in {}", result.getName(), currentThread().getName());
    List<String> errors = ErrorsCollector.getErrors();
    if (errors != null && !errors.isEmpty()) {
      throw new AssertionError("Errors found: " + errors);
    }
  }
}
