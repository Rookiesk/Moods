package cafe.moods.authority;

import cafe.moods.authority.exception.AuthorityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chertpong on 9/25/2016.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityDao authorityDao;

    @Override
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    @Override
    public Authority findById(Long id) {
        return authorityDao.findById(id).orElseThrow(AuthorityNotFoundException::new);
    }

    @Override
    public Authority findOneByName(String name) {
        return authorityDao.findOneByName(name).orElseThrow(AuthorityNotFoundException::new);
    }

    @Override
    public Authority create(Authority authority) {
        return authorityDao.create(authority);
    }

    @Override
    public Authority update(Authority authority) {
        return authorityDao.update(authority);
    }

    @Override
    public void delete(Long id) {
        authorityDao.delete(id);
    }
}
