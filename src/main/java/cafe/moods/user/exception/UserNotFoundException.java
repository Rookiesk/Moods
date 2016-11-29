package cafe.moods.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Chertpong on 10/13/2016.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User is not found in the system")
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User is not found in the system");
    }
}
