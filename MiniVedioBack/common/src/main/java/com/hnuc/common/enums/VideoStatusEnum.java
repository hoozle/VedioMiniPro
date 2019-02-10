package com.hnuc.common.enums;

public enum VideoStatusEnum {

    SUCCESS(1),		// 发布成功
    FORBIDDEN(2);		// 禁止播放，管理员操作

    int value;

    VideoStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
