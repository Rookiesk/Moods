package cafe.moods.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneById(Long id);
    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByEmail(String email);
}
