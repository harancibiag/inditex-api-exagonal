package es.inditex.inditextapi.infraestructure.security.service;

import es.inditex.inditextapi.application.mapper.UserMapper;
import es.inditex.inditextapi.domain.dto.UserDTO;
import es.inditex.inditextapi.domain.dto.request.AuthLoginRequest;
import es.inditex.inditextapi.domain.dto.response.AuthResponse;
import es.inditex.inditextapi.infraestructure.adapter.entity.UserEntity;
import es.inditex.inditextapi.infraestructure.security.jwt.JwtUtils;
import es.inditex.inditextapi.infraestructure.security.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDetailServiceImpl(JwtUtils jwtUtils, PasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMapper) {
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        UserDTO userDTO = userMapper.toDTO(userEntity);

        List<SimpleGrantedAuthority> authorityList = userDTO.getRoles().stream()
                .flatMap(role -> role.getPermissionList().stream().map(permission -> new SimpleGrantedAuthority(permission.getName())))
                .collect(Collectors.toList());

        authorityList.addAll(userDTO.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleEnum()))
                .collect(Collectors.toList()));

        return new User(userDTO.getUsername(), userEntity.getPassword(), userEntity.isEnabled(),
                userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(), authorityList);
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new AuthResponse(username, "User logged successfully", accessToken, true);
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }
}
