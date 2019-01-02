package com.hnuc.service.Impl;

import com.hnuc.MiniVedio.pojo.User;
import com.hnuc.MiniVedio.pojo.UserReport;
import com.hnuc.dao.UserMapper;
import com.hnuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        return false;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User queryUserForLogin(String username, String password) {
        return null;
    }

    @Override
    public void updateUserInfo(User user) {

    }

    @Override
    public User queryUserInfo(String userId) {
        return null;
    }

    @Override
    public boolean isUserLikeVideo(String userId, String videoId) {
        return false;
    }

    @Override
    public void saveUserFanRelation(String userId, String fanId) {

    }

    @Override
    public void deleteUserFanRelation(String userId, String fanId) {

    }

    @Override
    public boolean queryIfFollow(String userId, String fanId) {
        return false;
    }

    @Override
    public void reportUser(UserReport userReport) {

    }
}
