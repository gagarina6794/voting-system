package ua.com.system.restaurant.vote.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "user_id"})})
public class Vote extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate registered;

    @JoinColumn(name = "restaurant_id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @JoinColumn(name = "user_id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Vote() {
    }

    public Vote(Integer id, LocalDate registered, Restaurant restaurant, User user) {
        super(id);
        this.registered = registered;
        this.restaurant = restaurant;
        this.user = user;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
