package service;

import encoder.PasswordEncoder;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import repository.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Suleyman Yildirim
 */
public class UserServiceTest {

    private static final String PASSWORD = "password";

    private static final User ENABLED_USER =
            new User("user id", "hash", true);

    private static final User DISABLED_USER =
            new User("disabled user id", "disabled user password hash", false);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Before
    public void setup() {
        userRepository = createUserRepository();
        passwordEncoder = createPasswordEncoder();
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    public void isValidUser() {

        assertTrue(userService.isValidUser(ENABLED_USER.getId(), PASSWORD));

        // userRepository had to be used to find a user with id="user id"
        verify(userRepository).findById(ENABLED_USER.getId());

        // passwordEncoder had to be used to compute a hash of "password"
        verify(passwordEncoder).encode(PASSWORD);
    }

    @Test
    public void isInvalidUser() {

        boolean userIsValid = userService.isValidUser("invalid id", PASSWORD);
        assertFalse(userIsValid);

        InOrder inOrder = inOrder(userRepository, passwordEncoder);
        inOrder.verify(userRepository).findById("invalid id");
        inOrder.verify(passwordEncoder, never()).encode(anyString());
    }


    private PasswordEncoder createPasswordEncoder() {
        PasswordEncoder mock = mock(PasswordEncoder.class);
        when(mock.encode(anyString())).thenReturn("any password hash");
        when(mock.encode(PASSWORD)).thenReturn(ENABLED_USER.getPasswordHash());
        return mock;
    }

    private UserRepository createUserRepository() {
        UserRepository mock = mock(UserRepository.class);
        when(mock.findById(ENABLED_USER.getId())).thenReturn(ENABLED_USER);
        when(mock.findById(DISABLED_USER.getId())).thenReturn(DISABLED_USER);
        return mock;
    }
}