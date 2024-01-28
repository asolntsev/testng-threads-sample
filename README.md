# testng-threads-sample
Sample project to reproduce issue with tests having a timeout

## The problem
When run `./gradlew test`, only one test fails: `WithTimeoutTest.myTest`

## Expected behaviour:
Another test should also fail: `WithTimeoutTest.myTestWithTimeout`