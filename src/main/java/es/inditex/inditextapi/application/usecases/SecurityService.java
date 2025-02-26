package es.inditex.inditextapi.application.usecases;

import es.inditex.inditextapi.domain.dto.request.AuthLoginRequest;
import es.inditex.inditextapi.domain.dto.response.AuthResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
    UserDetails loadUserByUsername(String username);

    AuthResponse loginUser(AuthLoginRequest authLoginRequest);

    Authentication authenticate(String username, String password);
}
