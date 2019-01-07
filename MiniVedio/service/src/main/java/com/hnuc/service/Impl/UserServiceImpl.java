package com.hnuc.service.Impl;


import com.hnuc.common.util.UUIDUtil;
import com.hnuc.dao.UserMapper;
import com.hnuc.pojo.User;
import com.hnuc.pojo.UserReport;
import com.hnuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        User user = null;

        user = userMapper.selectByUsername(username);

        if(null != user){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void saveUser(User user) {
        if(null != user){
            user.setId(UUIDUtil.getUUID());
            userMapper.insert(user);
        }

    }

    @Override
    public User queryUserForLogin(String username, String password) {
        User user = null;
        user = userMapper.selectByUsernameAndPwd(username, password);
        return user;
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
