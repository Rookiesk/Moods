package cafe.moods.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chertpong on 11/20/2016.
 */
@RestController
public class TokenController {
//    @Autowired
//    private DefaultTokenServices defaultTokenServices;
//
//    @PostMapping("/oauth/token/revoke")
//    public void revoke(@RequestParam("token") String value) throws InvalidClientException {
//        defaultTokenServices.revokeToken(value);
//    }

}
