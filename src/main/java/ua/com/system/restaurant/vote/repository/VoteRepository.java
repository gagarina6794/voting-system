package ua.com.system.restaurant.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.system.restaurant.vote.model.Vote;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v LEFT JOIN FETCH v.user WHERE v.restaurant.id=:restaurant_id")
    List<Vote> findAllByRestaurantId(@Param("restaurant_id") int restaurantId);
}
