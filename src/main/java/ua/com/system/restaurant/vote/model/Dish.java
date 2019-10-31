package ua.com.system.restaurant.vote.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "restaurant_id"})})
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @JoinColumn(name = "restaurant_id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Menu> menus;

    public Dish() {
    }

    public Dish(Integer id, String name, BigDecimal price, Restaurant restaurant, Set<Menu> menus) {
        super(id, name);
        this.price = price;
        this.restaurant = restaurant;
        setMenus(menus);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = CollectionUtils.isEmpty(menus) ? new HashSet<>() : Set.copyOf(menus);
    }
}
