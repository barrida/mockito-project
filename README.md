# Mocks
  What is mocking?  
  
  Mocking for unit testing is when you create an object that implements the behavior of a real subsystem in controlled ways. In short, mocks are used as a replacement for a dependency.
  
  With Mockito, you create a mock, tell Mockito what to do when specific methods are called on it, and then use the mock instance in your test instead of the real thing. After the test, you can query the mock to see what specific methods were called or check the side effects in the form of changed state.
  
  By default, Mockito provides an implementation for every method of the mock.
  
# Spies

A spy is the other type of test double that Mockito creates. In contrast to mocks, creating a spy requires an instance to spy on. By default, a spy delegates all method calls to the real object and records what method was called and with what parameters. That’s what makes it a spy: It’s spying on a real object.

Consider using mocks instead of spies whenever possible. Spies might be useful for testing legacy code that can’t be redesigned to be easily testable, but the need to use a spy to partially mock a class is an indicator that a class is doing too much, thus violating the single responsibility principle.  

