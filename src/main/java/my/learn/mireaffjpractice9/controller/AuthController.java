package my.learn.mireaffjpractice9.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice9.dto.request.UserLoginRequest;
import my.learn.mireaffjpractice9.dto.request.UserRegisterRequest;
import my.learn.mireaffjpractice9.dto.responce.UserDTO;
import my.learn.mireaffjpractice9.model.User;
import my.learn.mireaffjpractice9.service.UserService;
import my.learn.mireaffjpractice9.util.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registrateNewUser(@Valid @RequestBody UserRegisterRequest request) {
        User saved = userService.save(request);
        return new ResponseEntity<>(UserMapper.mapToDTO(saved), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserLoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User principal = (User) auth.getPrincipal();
        return new ResponseEntity<>(UserMapper.mapToDTO(principal), HttpStatus.OK);
    }

}
