package cafe.moods.user;

import cafe.moods.authority.Authority;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByEmail(String email);
    User create(User user);
    User update(String firstName, String lastName, String email, String password);
    User update(Long id, String firstName, String lastName, String email, Set<Authority> authorities);
    void delete(Long id);
}
