package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.RoleDTO;
import es.inditex.inditextapi.infraestructure.adapter.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDTO toDTO(RoleEntity roleEntity);
    RoleEntity toEntity(RoleDTO roleDTO);
}