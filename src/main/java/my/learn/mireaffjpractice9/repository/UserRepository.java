package my.learn.mireaffjpractice9.repository;

import my.learn.mireaffjpractice9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
