package cafe.moods.authority;

import java.util.List;

/**
 * Created by Chertpong on 9/25/2016.
 */
public interface AuthorityService {
    List<Authority> findAll();
    Authority findById(Long id);
    Authority findOneByName(String name);
    Authority create(Authority authority);
    Authority update(Authority authority);
    void delete(Long id);
}
