package my.learn.mireaffjpractice9.service;

import my.learn.mireaffjpractice9.dto.request.UserRegisterRequest;
import my.learn.mireaffjpractice9.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegisterRequest req);

}
