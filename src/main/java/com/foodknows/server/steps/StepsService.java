package com.foodknows.server.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class StepsService {
    @Autowired
    private StepsRepo stepsRepo;

    boolean saveSteps(String openId, Steps steps) {
        steps.setOpenId(openId);
        stepsRepo.save(steps);
        return true;
    }

    List <DailySteps> getDaily(String openId, Timestamp startTime, Timestamp endTime) {
        List <DailySteps> dailyList = new ArrayList <>();
        long tempStart = startTime.getTime() - ((startTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        long tempEnd = endTime.getTime() - ((endTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        int between = (int) ((tempEnd - tempStart) / (24 * 60 * 60 * 1000L));
        for (int i = 0; i <= between; i++) {
            tempEnd = tempStart + 24 * 60 * 60 * 1000L;
            List <Steps> stepsList = stepsRepo.findAllByOpenIdAndTimeBetween(openId, new Timestamp(tempStart), new Timestamp(tempEnd));
            int totalSteps = 0;
            for(Steps steps: stepsList) {
                totalSteps += steps.getSteps();
            }
            DailySteps dailySteps = new DailySteps(new Timestamp(tempStart), totalSteps);
            dailyList.add(dailySteps);
            tempStart = tempEnd;
        }
        return dailyList;
    }
}
