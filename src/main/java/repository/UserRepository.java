package repository;

import entity.User;

/**
 * @author Suleyman Yildirim
 */
public interface UserRepository {
    User findById(String id);
}
