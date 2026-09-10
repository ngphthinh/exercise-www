package iuh.fit.se.de01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private String username;
    private String password;
    private String role;   // "ADMIN" hoặc "USER"
}