package org.training.spring.springtraining20240603.security;

import jakarta.persistence.*;

@Entity
@Table(name = "my_user", indexes = @Index(name = "user_index", columnList = "username", unique = true))
public class UserObj {
    @Id
    @GeneratedValue
    private Long   userId;
    private String username;
    private String password;
    private String myRole;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userIdParam) {
        userId = userIdParam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String usernameParam) {
        username = usernameParam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String passwordParam) {
        password = passwordParam;
    }

    public String getMyRole() {
        return myRole;
    }

    public void setMyRole(final String myRoleParam) {
        myRole = myRoleParam;
    }
}
