package com.foodknows.server.food;

import com.foodknows.server.Request;
import com.foodknows.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    //上传食物信息
    @RequestMapping(value="", method= RequestMethod.POST)
    public Response postHistory(@RequestBody Request <Food> request) {
        boolean isSuccess = foodService.saveFood(request.getOpenId(), request.getReqParam());
        String message;
        if (isSuccess == true) {
            message = "上传记录成功";
        } else {
            message = "上传记录失败";
        }
        Response response = new Response(isSuccess, message, null);
        return response;
    }

    //获取食物占比
    @RequestMapping(value="/ratio", method= RequestMethod.GET)
    public Response<Map <String, Timestamp>> getRatio(@RequestBody Request <Map <String, Timestamp>> request) {
        Map<String, Double> resData = foodService.getRatio(request.getOpenId(), request.getReqParam().get("time"));
        boolean isSuccess;
        String message;
        if (!resData.isEmpty()) {
            isSuccess = true;
            message = "获取食物占比成功";
        } else {
            isSuccess = false;
            message = "今日无食物记录";
        }
        Response response = new Response(isSuccess, message, resData);
        return response;
    }

    @RequestMapping(value="/daily", method= RequestMethod.GET)
    public Response<Map <String, Timestamp>> getDaily(@RequestBody Request <Map <String, Timestamp>> request) {
        List <DailyCalories> resData = foodService.getDaily(request.getOpenId(),
                request.getReqParam().get("startTime"), request.getReqParam().get("endTime"));
        boolean isSuccess;
        String message;
        if (!resData.isEmpty()) {
            isSuccess = true;
            message = "获取每日卡路里成功";
        } else {
            isSuccess = false;
            message = "获取每日卡路里失败";
        }
        Response response = new Response(isSuccess, message, resData);
        return response;
    }
}
