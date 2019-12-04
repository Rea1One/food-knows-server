package com.foodknows.server.steps;

import com.foodknows.server.Request;
import com.foodknows.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StepsController {
    @Autowired
    private StepsService stepsService;

    @RequestMapping(value="/steps", method= RequestMethod.POST)
    public Response postHistory(@RequestBody Request<Steps> request) {
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

    @RequestMapping(value="/steps/daily",method = RequestMethod.GET)
    public Response getHistory(@RequestBody Request<Steps> request) {
        Steps steps=stepsService.findSteps(request.getOpenId());
        boolean isSuccess = steps != null ? true : false;
        String message;
        if(isSuccess==true){
            message = "获取步数成功";
        } else {
            message = "获取步数失败";
        }
        Response response = new Response(isSuccess,message,steps);
        return response;
    }
}
