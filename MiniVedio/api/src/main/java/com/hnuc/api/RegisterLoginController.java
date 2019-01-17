package com.hnuc.api;

import com.hnuc.common.util.JSONResult;
import com.hnuc.common.util.MD5Util;
import com.hnuc.common.util.RedisUtil;
import com.hnuc.common.util.UUIDUtil;
import com.hnuc.pojo.User;
import com.hnuc.pojo.VO.UserVO;
import com.hnuc.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RegisterLoginController extends BaseController{
    @Autowired
    UserService userService;

    //用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResult register(@RequestBody User user) throws Exception {
        //对用户名和密码进行判空
        if (null == user || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名或密码不能为空");

        }
        //查询用户是否存在
        if(userService.queryUsernameIsExist(user.getUsername())) {
            return JSONResult.errorMsg("用户名已存在");
        }

        //保存用户
        user.setNickname(user.getUsername());
        user.setPassword(MD5Util.getMD5Str(user.getPassword()));
        user.setFansCounts(0);
        user.setReceiveLikeCounts(0);
        user.setFollowCounts(0);
        userService.saveUser(user);

        user.setPassword("");

        return JSONResult.retOK(user);
    }

    //用户登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResult login(@RequestBody User user) throws Exception {
        //对用户名和密码进行判空
        if (null == user || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        user = userService.queryUserForLogin(user.getUsername(), MD5Util.getMD5Str(user.getPassword()));

        if(null != user){
            user.setPassword("");
            UserVO userVO = setUserRedisSessionToken(user);
            return  JSONResult.retOK(userVO);
        }else{
            return JSONResult.errorMsg("用户名或密码错误");
        }
    }

    //用户注销
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public JSONResult logout(String userID) throws Exception {
        if(null != userID) {
            redisUtil.del(USER_REDIS_SESSION + ":" + userID);
            return JSONResult.retOK(null);
        }else{
            return JSONResult.errorMsg("用户不存在");
        }
    }
    private UserVO setUserRedisSessionToken(User user) {
        String uniqueToken = UUIDUtil.getUUID();

        redisUtil.set(USER_REDIS_SESSION + ":" + user.getId(), uniqueToken, 1000 * 60 * 30);

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setUserToken(uniqueToken);
        return userVO;
    }
}
