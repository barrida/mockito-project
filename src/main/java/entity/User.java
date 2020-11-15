package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Suleyman Yildirim
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String passwordHash;
    private boolean enabled;
}
