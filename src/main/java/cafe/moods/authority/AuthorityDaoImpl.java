package cafe.moods.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Chertpong on 9/25/2016.
 */
@Repository
public class AuthorityDaoImpl implements AuthorityDao{
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Optional<Authority> findById(Long id) {
        return authorityRepository.findOneById(id);
    }

    @Override
    public Optional<Authority> findOneByName(String name) {
        return authorityRepository.findOneByName(name);
    }

    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority update(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void delete(Long id) {
        authorityRepository.delete(id);
    }
}
