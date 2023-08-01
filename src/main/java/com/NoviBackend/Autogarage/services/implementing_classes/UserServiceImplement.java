package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.UserDTO;
import com.NoviBackend.Autogarage.exception.ResourceNotFoundException;
import com.NoviBackend.Autogarage.mapper.UserMapper;
import com.NoviBackend.Autogarage.models.User;
import com.NoviBackend.Autogarage.repositories.UserRepository;
import com.NoviBackend.Autogarage.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService {

    private UserRepository userRepository;

    @Override   //Method to add a user
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override  //Method to get a singular user by id
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The user with id: " + id + ", does not exist"));

        return UserMapper.mapToUserDTO(user);
    }

    @Override //Method to get all users
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDTO(user)).collect(Collectors.toList());
    }

    @Override //Method to update a single user
    public UserDTO updateUser(Long id, UserDTO updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The user with id: " + id + ", does not exist"));

        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        User updatedUserOBJ = userRepository.save(user);

        return UserMapper.mapToUserDTO(updatedUserOBJ);
    }

    @Override //Method to delete a user
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The user with id: " + id + ", does not exist"));

        userRepository.deleteById(id);
    }


}
