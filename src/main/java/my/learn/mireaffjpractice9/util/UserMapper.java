package my.learn.mireaffjpractice9.util;

import my.learn.mireaffjpractice9.dto.responce.UserDTO;
import my.learn.mireaffjpractice9.model.User;

public class UserMapper {

    public static UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}
