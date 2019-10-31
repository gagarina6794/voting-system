package ua.com.system.restaurant.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.system.restaurant.vote.model.Menu;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurant_id")
    Optional<Menu> findByRestaurantIdAndId(@Param(value = "restaurant_id") int restaurantId, @Param(value = "id") int id);
}