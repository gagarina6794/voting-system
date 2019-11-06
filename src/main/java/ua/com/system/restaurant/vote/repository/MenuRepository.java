package ua.com.system.restaurant.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.system.restaurant.vote.model.Menu;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByIdAndRestaurantId(int id, int restaurantId);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.dishes WHERE m.id=:id AND m.restaurant.id=:restaurant_id")
    Menu findWithDishes(@Param("id") int id, @Param("restaurant_id") int restaurantId);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.dishes WHERE m.restaurant.id=:restaurant_id")
    List<Menu> findAllByRestaurantId(@Param("restaurant_id") int restaurantId);
}