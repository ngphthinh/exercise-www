package iuh.fit.se.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return "student".equals(username.trim()) && "123456".equals(password.trim());
    }
}