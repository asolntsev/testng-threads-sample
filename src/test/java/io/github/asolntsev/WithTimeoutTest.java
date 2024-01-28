package io.github.asolntsev;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class WithTimeoutTest {

  @Test
  public void myTest() {
    if (Math.random() > -0.001) {
      ErrorsCollector.addError("One");
    }
  }

  @Test(timeOut = 99999)
  public void myTestWithTimeout() {
    if (Math.random() > -0.001) {
      ErrorsCollector.addError("Two");
    }
  }

}
