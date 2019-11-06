package ua.com.system.restaurant.vote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.system.restaurant.vote.model.Dish;
import ua.com.system.restaurant.vote.model.Menu;
import ua.com.system.restaurant.vote.model.Vote;
import ua.com.system.restaurant.vote.repository.DishRepository;
import ua.com.system.restaurant.vote.repository.MenuRepository;
import ua.com.system.restaurant.vote.repository.VoteRepository;
import ua.com.system.restaurant.vote.to.VoteDateTo;
import ua.com.system.restaurant.vote.to.VoteTo;
import ua.com.system.restaurant.vote.util.VotesCounter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;
    private final VoteRepository voteRepository;

    public MainController(MenuRepository menuRepository, DishRepository dishRepository, VoteRepository voteRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello voting system!";
    }

    @GetMapping("restaurants/{rest_id}/menus")
    public List<Menu> getAllMenus(@PathVariable(name = "rest_id") int restaurantId) {
        return menuRepository.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("restaurants/{rest_id}/menus/{id}")
    public Menu getMenuWithDishes(@PathVariable(name = "rest_id") int restaurantId, @PathVariable int id) {
        return menuRepository.findWithDishes(id, restaurantId);
    }

    @GetMapping("/menus/{id}/dishes")
    public List<Dish> allDishes(@PathVariable int id) {
        return dishRepository.findAllByMenuId(id);
    }

    @GetMapping("restaurants/{rest_id}/votes")
    public List<VoteTo> getAllVotes(@PathVariable(name = "rest_id") int restaurantId) {
        final List<Vote> votes = voteRepository.findAllByRestaurantId(restaurantId);
        return votes.stream().map(VoteTo::new).collect(Collectors.toList());
    }

    @GetMapping("restaurants/{rest_id}/votes/count")
    public List<VoteDateTo> getAllVotesCountByDate(@PathVariable(name = "rest_id") int restaurantId) {
        final List<Vote> votes = voteRepository.findAllByRestaurantId(restaurantId);
        return VotesCounter.getVoteDateTos(votes);
    }
}
