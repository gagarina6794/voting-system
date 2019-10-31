package ua.com.system.restaurant.vote.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Restaurant extends AbstractRegisteredEntity {

    @JoinColumn(name = "user_id")
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, Date registered, User user) {
        super(id, name, registered);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
