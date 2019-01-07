package com.hnuc.api;

import com.hnuc.common.util.JSONResult;
import com.hnuc.common.util.MD5Util;
import com.hnuc.pojo.User;
import com.hnuc.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterLoginController {

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


        return new JSONResult(user);
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
            return  new JSONResult(user);
        }else{
            return JSONResult.errorMsg("用户名或密码错误");
        }


    }
}
