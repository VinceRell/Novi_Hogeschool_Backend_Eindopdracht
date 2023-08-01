package com.NoviBackend.Autogarage.services;

import com.NoviBackend.Autogarage.dto.UserDTO;

import java.util.List;

public interface UserService {
   //Service for creating a user
   UserDTO createUser(UserDTO userDTO);

   //Service for getting a single user
   UserDTO getUserById(Long id);

   //Service for getting all users
   List<UserDTO> getAllUsers();

   //Service to update a user
   UserDTO updateUser(Long id, UserDTO updatedUser);

   //Service to delete a user
   void deleteUserById(Long id);
}