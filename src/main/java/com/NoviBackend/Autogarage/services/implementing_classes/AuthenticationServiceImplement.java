package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.UserDTO;
import com.NoviBackend.Autogarage.mapper.UserMapper;
import com.NoviBackend.Autogarage.models.UserEntity;
import com.NoviBackend.Autogarage.repositories.UserRepository;
import com.NoviBackend.Autogarage.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthenticationService {

    private final UserRepository userRepository;

    @Override //Method to add a new user to the database
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity user = UserMapper.mapToUser(userDTO);
        UserEntity savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }
}
