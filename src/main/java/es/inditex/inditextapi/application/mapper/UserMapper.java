package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.UserDTO;
import es.inditex.inditextapi.infraestructure.adapter.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}