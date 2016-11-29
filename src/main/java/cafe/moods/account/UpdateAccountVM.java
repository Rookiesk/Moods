package cafe.moods.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Chertpong on 10/16/2016.
 */
@Data
public class UpdateAccountVM {
    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    private String password;

    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(min = 1, max = 36)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 64)
    private String lastName;
}
