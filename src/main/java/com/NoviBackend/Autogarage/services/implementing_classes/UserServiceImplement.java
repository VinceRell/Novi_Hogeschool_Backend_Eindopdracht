package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.UserDTO;
import com.NoviBackend.Autogarage.exception.ResourceNotFoundException;
import com.NoviBackend.Autogarage.mapper.UserMapper;
import com.NoviBackend.Autogarage.models.UserEntity;
import com.NoviBackend.Autogarage.repositories.UserRepository;
import com.NoviBackend.Autogarage.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService {

    private UserRepository userRepository;

    @Override //Method to get a singular user by id
    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The userEntity with id: " + id + ", does not exist"));

        return UserMapper.mapToUserDTO(userEntity);
    }

    @Override //Method to get all users
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map((userEntity) -> UserMapper.mapToUserDTO(userEntity)).collect(Collectors.toList());
    }

    @Override //Method to update a single user
    public UserDTO updateUser(Long id, UserDTO updatedUser) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The userEntity with id: " + id + ", does not exist"));

        userEntity.setFirstname(updatedUser.getFirstname());
        userEntity.setLastname(updatedUser.getLastname());
        userEntity.setEmail(updatedUser.getEmail());
        userEntity.setPassword(updatedUser.getPassword());

        UserEntity updatedUserOBJEntity = userRepository.save(userEntity);

        return UserMapper.mapToUserDTO(updatedUserOBJEntity);
    }

    @Override //Method to delete a user
    public void deleteUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The userEntity with id: " + id + ", does not exist"));

        userRepository.deleteById(id);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }


}
