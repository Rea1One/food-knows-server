package com.foodknows.server.steps;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StepsRepo extends JpaRepository <Steps, Long> {
    Steps findStepsByOpenId(String openId);
}
