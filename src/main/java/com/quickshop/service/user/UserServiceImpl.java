package com.quickshop.service.user;


import com.quickshop.adapter.user.UserPersistenceAdapter;
import com.quickshop.exception.BadRequestException;
import com.quickshop.exception.GlobalExceptionHandler;
import com.quickshop.exception.ResourceNotFoundException;
import com.quickshop.mapper.user.UserApiMapper;
import com.quickshop.model.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPersistenceAdapter userPersistenceAdapter;
    private final UserApiMapper userApiMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse registerUser(CreateUserRequest request) {
        if (userPersistenceAdapter.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already registered: " + request.getEmail());
        }

        UserEntity userEntity = userApiMapper.toUserEntity(request);
        userEntity.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        UserEntity savedUser = userPersistenceAdapter.saveUser(userEntity);
        return userApiMapper.toUserResponse(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId) {
         UserEntity user = userPersistenceAdapter.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        return userApiMapper.toUserResponse(user);
    }

    @Override
    @Transactional
    public Address addAddress(Long userId, Address addressDto) {
        UserEntity user = userPersistenceAdapter.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        AddressEntity addressEntity = userApiMapper.toAddressEntity(addressDto);
        addressEntity.setUser(user);

        AddressEntity savedAddress = userPersistenceAdapter.saveAddress(addressEntity);
        return userApiMapper.toAddress(savedAddress);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> getUserAddresses(Long userId) {
        List<AddressEntity> addresses = userPersistenceAdapter.findAddressesByUserId(userId);
        return userApiMapper.toAddressDtoList(addresses);
    }
}
