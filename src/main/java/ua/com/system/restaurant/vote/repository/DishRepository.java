package ua.com.system.restaurant.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.system.restaurant.vote.model.Vote;

@Repository
public interface DishRepository extends JpaRepository<Vote, Integer> {
}
