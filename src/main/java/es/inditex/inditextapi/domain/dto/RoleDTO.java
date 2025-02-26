package es.inditex.inditextapi.domain.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    private Long id;
    private String roleEnum;
    private Set<PermissionDTO> permissionList;
}
