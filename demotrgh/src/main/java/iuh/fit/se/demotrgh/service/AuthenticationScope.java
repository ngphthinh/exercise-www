package iuh.fit.se.demotrgh.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationScope {
    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }
}
