package com.hnuc.pojo.VO;

import com.hnuc.pojo.User;

public class UserVO extends User{

    private String userToken;

    private boolean isFollowing;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setFollowing(boolean following) {
        isFollowing = following;
    }
}
