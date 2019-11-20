package com.foodknows.server.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    boolean saveFood(String openId, Food food) {
        food.setOpenId(openId);
        foodRepo.save(food);
        return true;
    }
}
