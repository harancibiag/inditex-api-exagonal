package es.inditex.inditextapi.application.mapper;

import es.inditex.inditextapi.domain.dto.PermissionDTO;
import es.inditex.inditextapi.infraestructure.adapter.entity.PermissionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toDTO(PermissionEntity permissionEntity);
    PermissionEntity toEntity(PermissionDTO permissionDTO);
}