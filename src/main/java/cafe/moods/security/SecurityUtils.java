package cafe.moods.security;

import cafe.moods.user.exception.UserNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Chertpong on 10/13/2016.
 */
@Service
public class SecurityUtils {

    public static String getCurrentUsername(){
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        return authentication.map(auth -> {
                    if(auth.getPrincipal() instanceof UserDetails){
                        return ((UserDetails)auth.getPrincipal()).getUsername();
                    }
                    return auth.getPrincipal().toString();
                })
                .orElseThrow(UserNotFoundException::new);
    }
}
