package com.quickshop.adapter.user;


import com.quickshop.model.user.AddressEntity;
import com.quickshop.model.user.UserEntity;
import com.quickshop.repository.user.AddressRepository;
import com.quickshop.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public AddressEntity saveAddress(AddressEntity address) {
        return addressRepository.save(address);
    }

    public List<AddressEntity> findAddressesByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}