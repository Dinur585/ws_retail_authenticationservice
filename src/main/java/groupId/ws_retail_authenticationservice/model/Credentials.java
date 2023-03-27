package groupId.ws_retail_authenticationservice.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    @Email(message = "Email cannot be null")
    private String username;
    private String password;
}
