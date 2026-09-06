package com.quickshop.mapper.user;



import com.quickshop.model.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserEntity toUserEntity(CreateUserRequest request);

    UserResponse toUserResponse(UserEntity entity);

    @Mapping(target = "user", ignore = true)
    AddressEntity toAddressEntity(Address dto);

    Address toAddress(AddressEntity entity);

    List<Address> toAddressDtoList(List<AddressEntity> entities);
}
