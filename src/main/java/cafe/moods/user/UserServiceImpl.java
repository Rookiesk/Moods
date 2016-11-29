package cafe.moods.user;

import cafe.moods.authority.Authority;
import cafe.moods.authority.AuthorityService;
import cafe.moods.security.SecurityUtils;
import cafe.moods.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Chertpong on 9/25/2016.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorityService authorityService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userDao.findOneByUsername(username);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return userDao.findOneByEmail(email);
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    public User update(String firstName, String lastName, String email, String password) {
        User user = userDao.findOneByUsername(SecurityUtils.getCurrentUsername()).orElseThrow(UserNotFoundException::new);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userDao.update(user);
    }


    @Override
    public User update(Long id,String firstName, String lastName, String email, Set<Authority> authorities) {
        User user = userDao.findById(id).orElseThrow(UserNotFoundException::new);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        Set<Authority> newAuthorities = authorities.stream()
                .map(authority -> authorityService.findOneByName(authority.getName()))
                .filter(authority -> authority != null)
                .collect(Collectors.toSet());
        user.setAuthorities(newAuthorities);
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
