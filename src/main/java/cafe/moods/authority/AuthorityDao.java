package cafe.moods.authority;

import java.util.List;
import java.util.Optional;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface AuthorityDao {
    List<Authority> findAll();
    Optional<Authority> findById(Long id);
    Optional<Authority> findOneByName(String name);
    Authority create(Authority authority);
    Authority update(Authority authority);
    void delete(Long id);
}
