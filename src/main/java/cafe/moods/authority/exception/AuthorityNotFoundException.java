package cafe.moods.authority.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 10/13/2016.
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Authority not found")
public class AuthorityNotFoundException extends RuntimeException{
    public AuthorityNotFoundException() {
        super("Authority not found");
    }
}

