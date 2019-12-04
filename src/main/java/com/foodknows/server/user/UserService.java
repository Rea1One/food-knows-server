package com.foodknows.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    boolean saveUser(String openId, User user) {
        if (openId != null && user != null) {
            user.setOpenId(openId);
            if (user.getWeight() != 0 && user.getSex() != null && user.getName() != null && user.getHeight() != 0) {
                userRepo.save(user);
                return true;
            }
        }
        return false;
    }

    User findUser(String openId) {
        return userRepo.findUserByOpenId(openId);
    }

    boolean updateUser(String openId, User user) {
        User old = userRepo.findUserByOpenId(openId);
        if (openId != null && user != null) {
            if (user.getHeight() != 0) {
                old.setHeight(user.getHeight());
            }
            if (user.getName() != null) {
                old.setName(user.getName());
            }
            if (user.getProfile() != null) {
                old.setProfile(user.getProfile());
            }
            if (user.getSex() != null) {
                old.setSex(user.getSex());
            }
            if (user.getWeight() != 0) {
                old.setWeight(user.getWeight());
            }
            userRepo.save(old);
            return true;
        }
        return false;
    }
}
