package cafe.moods.security;

import cafe.moods.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Chertpong on 9/27/2016.
 */
@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findOneByUsername(username)
                .map(user -> {
                    Set<SimpleGrantedAuthority> authorities = user
                            .getAuthorities()
                            .stream()
                            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                            .collect(Collectors.toSet());
                    return new User(user.getUsername(),user.getPassword(), authorities);
                })
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
