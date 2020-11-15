package mockito;

import encoder.PasswordEncoder;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author Suleyman Yildirim
 * <p>
 * Mockito offers two ways of stubbing:
 * <p>
 * 1) when(...).thenReturn(...) approach
 * <p>
 * 2) doReturn(...).when(...).functionOfStub() approach
 */
public class TestStubbing {

    @Test
    public void when_this_method_is_called_then_do_something() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class); // mock the class
        when(passwordEncoder.encode("1")).thenReturn("a"); // “When passwordEncoder.encode(“1”) is called, return an a.”
    }

    @Test
    public void when_this_method_is_called_then_throw_exception() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class); // mock the class
        when(passwordEncoder.encode("-1")).thenThrow(new IllegalArgumentException());
    }

    @Test
    public void do_something_when_this_method_is_called_with_the_following_arguments() {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class); // mock the class
        doReturn("a").when(passwordEncoder).encode("1"); // “Return a when passwordEncoder’s encode() method is called with an argument of 1.”
    }
}
