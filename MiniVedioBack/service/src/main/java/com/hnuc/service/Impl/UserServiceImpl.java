package com.hnuc.service.Impl;


import com.hnuc.common.util.IdGenerator;
import com.hnuc.dao.UserFanMapper;
import com.hnuc.dao.UserMapper;
import com.hnuc.pojo.User;
import com.hnuc.pojo.UserFan;
import com.hnuc.pojo.UserReport;
import com.hnuc.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserFanMapper userFanMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(User user) {
        if(null != user){
            user.setId(IdGenerator.get());
            userMapper.insert(user);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User queryUserForLogin(String username, String password) {
        return userMapper.selectByUsernameAndPwd(username, password);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateUserInfo(User user) {
        if(null != user && null != user.getId()){
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User queryUserInfo(String userId) {
        if(userId == null) {
            return null;
        }else{
            return userMapper.selectByPrimaryKey(userId);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean isUserLikeVideo(String userId, String videoId) {
        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUserFanRelation(String userId, String fanId) {
        UserFan userFan = new UserFan();
        User user = userMapper.selectByPrimaryKey(userId);
        User fan = userMapper.selectByPrimaryKey(fanId);

        if((!StringUtils.isBlank(userId))
                && (!StringUtils.isBlank(fanId)
                && (user != null)
                || (fan != null))){
            userFan.setUserId(userId);
            userFan.setFanId(fanId);
            userFan.setId(IdGenerator.get());
            userFanMapper.insert(userFan);

            user.setFansCounts(user.getFansCounts() + 1);
            userMapper.updateByPrimaryKeySelective(user);

            fan.setFollowCounts(fan.getFollowCounts() + 1);
            userMapper.updateByPrimaryKeySelective(fan);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserFanRelation(String userId, String fanId) {
        User user = userMapper.selectByPrimaryKey(userId);
        User fan = userMapper.selectByPrimaryKey(fanId);

        if((!StringUtils.isBlank(userId))
                && (!StringUtils.isBlank(fanId)
                && (user != null)
                || (fan != null))){

            user.setFansCounts(user.getFansCounts() - 1);
            userMapper.updateByPrimaryKeySelective(user);

            fan.setFollowCounts(fan.getFollowCounts() - 1);
            userMapper.updateByPrimaryKeySelective(fan);

            userFanMapper.deleteByUserAndFanID(userId, fanId);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryIfFollow(String userId, String fanId) {
        Integer result = userFanMapper.selectByUserAndFanID(userId,fanId);
        if(null == result){
            return false;
        }else{
            return true;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void reportUser(UserReport userReport) {

    }
}
