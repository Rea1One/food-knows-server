package com.foodknows.server.steps;

import com.foodknows.server.Request;
import com.foodknows.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/steps")
public class StepsController {
    @Autowired
    private StepsService stepsService;

    @RequestMapping(value="", method= RequestMethod.POST)
    public Response postSteps(@RequestBody Request<Steps> request) {
        boolean isSuccess = stepsService.saveSteps(request.getOpenId(), request.getReqParam());
        String message;
        if (isSuccess == true) {
            message = "上传步数成功";
        } else {
            message = "上传步数失败";
        }
        Response response = new Response(isSuccess, message, null);
        return response;
    }


    @RequestMapping(value="/daily",method = RequestMethod.GET)
    public Response getSteps(@RequestBody Request <Map <String, Timestamp>> request) {
        List<DailySteps> resData=stepsService.getDaily(request.getOpenId(), request.getReqParam().get("startTime"), request.getReqParam().get("endTime"));
        boolean isSuccess;
        String message;
        if (!resData.isEmpty()) {
            isSuccess = true;
            message = "获取每日步数成功";
        } else {
            isSuccess = false;
            message = "获取每日步数失败";
        }
        Response response = new Response(isSuccess,message,resData);
        return response;
    }
}
