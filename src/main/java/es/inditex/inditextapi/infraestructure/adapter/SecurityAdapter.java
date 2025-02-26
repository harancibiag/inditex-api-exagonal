package es.inditex.inditextapi.infraestructure.adapter;

import es.inditex.inditextapi.domain.dto.request.AuthLoginRequest;
import es.inditex.inditextapi.domain.dto.response.AuthResponse;
import es.inditex.inditextapi.domain.ports.input.SecurityPersistencePort;
import es.inditex.inditextapi.infraestructure.security.service.UserDetailServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SecurityAdapter implements SecurityPersistencePort {
    private final UserDetailServiceImpl userDetailServiceImpl;

    public SecurityAdapter(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

    public UserDetails loadUserByUsername(String username) {
        return userDetailServiceImpl.loadUserByUsername(username);
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        return userDetailServiceImpl.loginUser(authLoginRequest);
    }

    public Authentication authenticate(String username, String password) {
        return userDetailServiceImpl.authenticate(username, password);
    }
}
