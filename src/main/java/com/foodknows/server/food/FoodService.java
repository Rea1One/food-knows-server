package com.foodknows.server.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    boolean saveFood(String openId, Food food) {
        food.setOpenId(openId);
        foodRepo.save(food);
        return true;
    }

    Map <String, Double> getRatio(String openId, Timestamp time) {
        long tempStart = time.getTime() - ((time.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        Timestamp startTime = new Timestamp(tempStart);
        long tempEnd = tempStart + 24*60*60*1000L;
        Timestamp endTime = new Timestamp(tempEnd);
        System.out.println(time.toLocalDateTime());
        System.out.println(startTime.toLocalDateTime());
        System.out.println(endTime.toLocalDateTime());
        List <FoodRatio> foodList = foodRepo.findRatio(openId, startTime, endTime);
        double sumCalories = 0;
        for(FoodRatio foodRatio: foodList) {
            sumCalories += foodRatio.getSumCalories();
        }
        Map<String, Double> ratioMap = new HashMap <>();
        for(FoodRatio foodRatio: foodList) {
            ratioMap.put(foodRatio.getName(), foodRatio.getSumCalories() / sumCalories);
        }
        return ratioMap;
    }

    List <DailyCalories> getDaily(String openId, Timestamp startTime, Timestamp endTime) {
        List <DailyCalories> dailyList = new ArrayList <>();
        long tempStart = startTime.getTime() - ((startTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        long tempEnd = endTime.getTime() - ((endTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        int between = (int) ((tempEnd - tempStart) / (24 * 60 * 60 * 1000L));
        for (int i = 0; i <= between; i++) {
            tempEnd = tempStart + 24 * 60 * 60 * 1000L;
            List <Food> foodList = foodRepo.findAllByOpenIdAndTimeBetween(openId,
                    new Timestamp(tempStart), new Timestamp(tempEnd));
            double calories = 0;
            for(Food food: foodList) {
                calories += food.getCalories() * food.getWeight();
            }
            DailyCalories dailyCalories = new DailyCalories(new Timestamp(tempStart), calories);
            dailyList.add(dailyCalories);
            tempStart = tempEnd;
        }

        return dailyList;
    }
}
