package com.foodknows.server.steps;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface StepsRepo extends JpaRepository <Steps, Long> {
    List<Steps> findAllByOpenIdAndTimeBetween(String openId, Timestamp startTime, Timestamp endTime);
}
