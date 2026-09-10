package iuh.fit.se.demo213.service;

import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@SessionScoped
@Getter
public class UserSession implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private String username;
    private String instanceId = UUID.randomUUID().toString();


    public void login(String username) {
        this.username = username;
    }


    public void logout() {
        this.username = null;
    }

    public boolean isAuthenticate() {
        return username != null;
    }

}
