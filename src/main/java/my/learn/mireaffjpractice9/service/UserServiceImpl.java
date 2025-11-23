package my.learn.mireaffjpractice9.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice9.dto.request.UserRegisterRequest;
import my.learn.mireaffjpractice9.exception.UserAlreadyExistException;
import my.learn.mireaffjpractice9.model.User;
import my.learn.mireaffjpractice9.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User save(UserRegisterRequest req) {
        User user = User.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .email(req.getEmail())
                .passwordHash(passwordEncoder.encode(req.getPassword()))
                .build();
        Optional<User> byEmail = userRepository.findByEmail(req.getEmail());
        if (byEmail.isPresent()) {
            throw new UserAlreadyExistException("User with email " + req.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
