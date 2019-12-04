package com.foodknows.server.user;

import com.foodknows.server.Request;
import com.foodknows.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Response postUserInfo(@RequestBody Request<User> request) {
        boolean isSuccess = userService.saveUser(request.getOpenId(), request.getReqParam());
        String message;
        if (isSuccess) {
            message = "上传用户信息成功";
        }
        else {
            message = "上传用户信息失败";
        }
        Response response = new Response(isSuccess, message, null);
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response getUserInfo(@RequestBody Request<User> request) {
        User user = userService.findUser(request.getOpenId());
        boolean isSuccess = user != null ? true : false;
        String message;
        if (isSuccess) {
            message = "获取账号信息成功";
        }
        else {
            message = "获取账号信息失败";
        }
        Response response = new Response(isSuccess, message, user);
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Response updateUserInfo(@RequestBody Request<User> request) {
        boolean isSuccess = userService.updateUser(request.getOpenId(), request.getReqParam());
        String message;
        if (isSuccess) {
            message = "更新账号信息成功";
        }
        else {
            message = "更新账号信息失败";
        }
        Response response = new Response(isSuccess, message, null);
        return response;
    }
}
