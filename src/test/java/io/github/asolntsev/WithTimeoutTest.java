package io.github.asolntsev;

import static java.lang.Thread.currentThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class WithTimeoutTest {
  private static final Logger log = LoggerFactory.getLogger(WithTimeoutTest.class);

  @Test
  public void myTest() {
    log.info("run test 'myTest' in {}", currentThread().getName());
    
    if (Math.random() > -0.001) {
      ErrorsCollector.addError("One");
    }
  }

  @Test(timeOut = 99999)
  public void myTestWithTimeout() {
    log.info("run test 'myTestWithTimeout' in {}", currentThread().getName());
    if (Math.random() > -0.001) {
      ErrorsCollector.addError("Two");
    }
  }

}
