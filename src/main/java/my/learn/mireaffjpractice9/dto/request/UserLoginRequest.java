package my.learn.mireaffjpractice9.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequest {

    @Email
    private String email;
    private String password;

}
