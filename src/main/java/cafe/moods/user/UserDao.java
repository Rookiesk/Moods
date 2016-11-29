package cafe.moods.user;

import java.util.List;
import java.util.Optional;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface UserDao {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByEmail(String email);
    User create(User user);
    User update(User user);
    void delete(Long id);
}
