package ua.com.system.restaurant.vote.to;

import ua.com.system.restaurant.vote.model.Vote;

import java.io.Serializable;
import java.time.LocalDate;

public class VoteTo implements Serializable {
    private Integer id;
    private LocalDate registration;
    private UserTo userTo;

    public VoteTo(Vote vote) {
        this.id = vote.getId();
        this.registration = vote.getRegistered();
        this.userTo = new UserTo(vote.getUser());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(UserTo userTo) {
        this.userTo = userTo;
    }
}
