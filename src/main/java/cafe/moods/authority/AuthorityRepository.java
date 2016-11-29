package cafe.moods.authority;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findOneById(Long id);
    Optional<Authority> findOneByName(String name);
}
