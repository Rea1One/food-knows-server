package com.foodknows.server.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository <Food, Long> {

}
