package com.foodknows.server.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.ListResourceBundle;

public interface FoodRepo extends JpaRepository <Food, Long> {
    List <Food> findAllByOpenIdAndTimeBetween(String openId, Timestamp startTime, Timestamp endTime);

    @Query("SELECT new com.foodknows.server.food.FoodRatio(f.name, SUM (f.calories * f.weight)) " +
            "FROM Food f " +
            "WHERE f.openId = ?1 AND f.time BETWEEN ?2 AND ?3 " +
            "GROUP BY f.name")
    List <FoodRatio> findRatio(String openId, Timestamp startTime, Timestamp endTime);
}
