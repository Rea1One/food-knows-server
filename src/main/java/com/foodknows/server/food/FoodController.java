package com.foodknows.server.food;

import com.foodknows.server.Request;
import com.foodknows.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

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
}
