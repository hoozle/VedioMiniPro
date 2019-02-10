package com.hnuc.pojo.VO;

import com.hnuc.pojo.Comment;

public class CommentVO extends Comment {
    private String fromUserFaceUrl;
    private String fromUserNickName;
    private String toUserNickName;
    private String formatTime;

    public String getFromUserFaceUrl() {
        return fromUserFaceUrl;
    }

    public void setFromUserFaceUrl(String fromUserFaceUrl) {
        this.fromUserFaceUrl = fromUserFaceUrl;
    }

    public String getFromUserNickName() {
        return fromUserNickName;
    }

    public void setFromUserNickName(String fromUserNickName) {
        this.fromUserNickName = fromUserNickName;
    }

    public String getToUserNickName() {
        return toUserNickName;
    }

    public void setToUserNickName(String toUserNickName) {
        this.toUserNickName = toUserNickName;
    }

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }
}
