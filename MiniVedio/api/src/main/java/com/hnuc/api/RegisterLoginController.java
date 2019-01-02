package com.hnuc.api;

import com.hnuc.MiniVedio.pojo.User;
import com.hnuc.common.util.JSONResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterLoginController {

    //用户注册
    public JSONResult register(@RequestBody User user) {
        //对用户名和密码进行判空
        if (null == user || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        //查询用户是否存在
        return null;
    }
}
