package com.hnuc.pojo.VO;

import com.hnuc.pojo.Video;

public class VideoVO extends Video {

    private String faceImage;

    private String nickname;

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
