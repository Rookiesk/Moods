package cafe.moods.account;

import cafe.moods.authority.Authority;
import cafe.moods.authority.AuthorityService;
import cafe.moods.user.User;
import cafe.moods.user.UserService;
import cafe.moods.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.security.Principal;

/**
 * Created by Chertpong on 10/16/2016.
 */
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;

    @RequestMapping(value = "/accounts/:id", method = RequestMethod.GET)
    public User findById(@PathParam("id") Long id){
        return userService.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public User create(@Valid @RequestBody RegisterAccountVM accountVM){
        User user = new User();
        user.setFirstName(accountVM.getFirstName());
        user.setLastName(accountVM.getLastName());
        user.setEmail(accountVM.getEmail());
        user.setUsername(accountVM.getUsername());
        user.setActivated(false);
        //set authorities
        Authority authority = authorityService.findOneByName("ROLE_USER");
        user.getAuthorities().add(authority);

        return userService.create(user);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.PUT)
    public User update(@Valid @RequestBody UpdateAccountVM accountVM){

        return userService.update(accountVM.getFirstName(),accountVM.getLastName(),accountVM.getEmail(),accountVM.getPassword());
    }

    @GetMapping("/accounts/me")
    public Principal me(Principal principal) {
        return principal;
    }

}
