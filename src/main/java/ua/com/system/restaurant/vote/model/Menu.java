package ua.com.system.restaurant.vote.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "date"})})
public class Menu extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate created;

    @JoinColumn(name = "restaurant_id")
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Dish> dishes;

    public Menu() {
    }

    public Menu(Integer id, LocalDate created, Restaurant restaurant, Set<Dish> dishes) {
        super(id);
        this.created = created;
        this.restaurant = restaurant;
        setDishes(dishes);
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = CollectionUtils.isEmpty(dishes) ? new HashSet<>() : Set.copyOf(dishes);
    }
}
