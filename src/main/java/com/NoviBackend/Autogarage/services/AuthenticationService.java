package com.NoviBackend.Autogarage.services;

import com.NoviBackend.Autogarage.dto.UserDTO;

public interface AuthenticationService {
    //Service for creating a user
    UserDTO createUser(UserDTO userDTO);
}
