package mockito;

import entity.Foo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Suleyman Yildirim
 * <p>
 * Sometimes, we don’t know the mocked methods' exact values as arguments beforehand.
 * <p>
 * In these cases, Argument Macthers allows us to pass different tyoes of arguments to the method to be stubbed
 * <p>
 * flexible verification or stubbing.
 * <p>
 * Mockito extends ArgumentMatchers so to get access to all matchers just import Mockito class statically.
 */
public class TestArgumentMatchers {

    private Foo foo;
    private String string;

    @Before
    public void setUp() throws Exception {
        foo = mock(Foo.class);
        string = new String();
    }

    @Test
    public void testAnyMatcherSimple() {
        when(foo.get(anyString(), any(Object.class))).thenReturn(0);
    }

    @Test
    public void testAnyMatcherWithEq() {
        //When we use argument matchers, then all the arguments should use matchers. If we want to use a specific value for an argument, then we can use eq() method.
        when(foo.get(eq("string"), any(Object.class))).thenReturn(0);
        when(foo.get(eq("string"), eq(Object.class))).thenReturn(0);
    }

    @Test
    public void testAnyMatcherAndVerify() {
        when(foo.get(anyString(), any(Object.class))).thenReturn(0);

        // call method get on the mock with parameter 1 and string object
        foo.get("1", string);

        // now verify the mock's get was called with the parameter 1 and a string object
        verify(foo).get(eq("1"), eq(string));

        // was the method called twice?
        verify(foo, times(1)).get(eq("1"), eq(string));

        verify(foo).get(anyString(), any(Object.class));

    }
}
