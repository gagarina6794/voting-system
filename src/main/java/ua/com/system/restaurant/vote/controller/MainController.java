package ua.com.system.restaurant.vote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.system.restaurant.vote.model.Menu;
import ua.com.system.restaurant.vote.repository.MenuRepository;

@RestController
public class MainController {

    MenuRepository menuRepository;

    public MainController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello voting system!";
    }

    @GetMapping("restaurant/{rest_id}/menu/{id}")
    public Menu allDishes(@PathVariable(name = "rest_id") int restaurant_id, @PathVariable int id) {
        return menuRepository.findByRestaurantIdAndId(restaurant_id, id).orElse(null);
    }
}
