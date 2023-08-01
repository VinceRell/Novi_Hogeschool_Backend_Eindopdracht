package com.NoviBackend.Autogarage.mapper;

import com.NoviBackend.Autogarage.dto.UserDTO;
import com.NoviBackend.Autogarage.models.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
    }

}
