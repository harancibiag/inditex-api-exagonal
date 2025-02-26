package es.inditex.inditextapi.application.services;

import es.inditex.inditextapi.application.usecases.SecurityService;
import es.inditex.inditextapi.domain.dto.request.AuthLoginRequest;
import es.inditex.inditextapi.domain.dto.response.AuthResponse;
import es.inditex.inditextapi.domain.ports.input.SecurityPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityManagementService implements SecurityService {
    private final SecurityPersistencePort securityPersistencePort;

    public SecurityManagementService(SecurityPersistencePort securityPersistencePort) {
        this.securityPersistencePort = securityPersistencePort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return securityPersistencePort.loadUserByUsername(username);
    }

    @Override
    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        return securityPersistencePort.loginUser(authLoginRequest);
    }

    @Override
    public Authentication authenticate(String username, String password) {
        return securityPersistencePort.authenticate(username, password);
    }
}
