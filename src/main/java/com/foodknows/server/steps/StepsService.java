package com.foodknows.server.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepsService {
    @Autowired
    private StepsRepo stepsRepo;

    boolean saveSteps(String openId, Steps steps) {
        if (openId != null && steps != null) {
            steps.setOpenId(openId);
            if (steps.getTime() != null && steps.getStartTime() != null && steps.getEndTime() != null && steps.getSteps() != 0) {
                stepsRepo.save(steps);
                return true;
            }
        }
        return false;
    }

    Steps findSteps(String openId) {
        return stepsRepo.findStepsByOpenId(openId);
    }
}
