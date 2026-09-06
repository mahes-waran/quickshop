package com.quickshop.service.user;


import com.quickshop.model.user.Address;
import com.quickshop.model.user.CreateUserRequest;
import com.quickshop.model.user.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse registerUser(CreateUserRequest request);
    UserResponse getUserById(Long userId);
    Address addAddress(Long userId, Address addressDto);
    List<Address> getUserAddresses(Long userId);
}
