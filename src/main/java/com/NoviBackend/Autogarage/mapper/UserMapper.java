package com.NoviBackend.Autogarage.mapper;

import com.NoviBackend.Autogarage.dto.UserDTO;
import com.NoviBackend.Autogarage.models.Role;
import com.NoviBackend.Autogarage.models.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    private static PasswordEncoder passwordEncoder;

    public static UserDTO mapToUserDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole().name());
    }

    public static UserEntity mapToUser(UserDTO userDTO) {
        return new UserEntity(
                userDTO.getId(),
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                Role.valueOf(userDTO.getRole()));
    }

}



