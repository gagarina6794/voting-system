package ua.com.system.restaurant.vote.to;

import ua.com.system.restaurant.vote.model.User;

import java.io.Serializable;

public class UserTo implements Serializable {
    private Integer id;
    private String name;
    private String email;

    public UserTo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
