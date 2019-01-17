package com.hnuc.pojo.VO;

import com.hnuc.pojo.User;

public class UserVO extends User{

    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
