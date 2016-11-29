package cafe.moods.user;

import cafe.moods.security.SecurityConstant;
import cafe.moods.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Chertpong on 10/13/2016.
 */
@RestController
@Secured(SecurityConstant.ROLE_ADMIN)
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/users/:id", method = RequestMethod.GET)
    public User findById(@PathParam("id") Long id){
        return userService.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User create(@Valid @RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public User update(@Valid @RequestBody User user){
        return userService.update(
                user.getId(),
                user.getFirstName(),
                user.getLastName()
                ,user.getEmail(),
                user.getAuthorities()
        );
    }
}
