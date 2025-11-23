package my.learn.mireaffjpractice9.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterRequest {

    @Email
    private String email;
    @NotBlank
    @Size(min = 5)
    private String password;

}
