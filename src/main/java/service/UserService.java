package service;

import encoder.PasswordEncoder;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import repository.UserRepository;

/**
 * @author Suleyman Yildirim
 */
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isValidUser(String id, String password) {
        User user = userRepository.findById(id);
        return isEnabledUser(user) && isValidPassword(user, password);
    }

    private boolean isEnabledUser(User user) {
        return user != null && user.isEnabled();
    }

    private boolean isValidPassword(User user, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword.equals(user.getPasswordHash());
    }


}
