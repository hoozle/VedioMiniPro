package com.hnuc.common.util;

public interface Constant {
    //用户数据的保存路径
    public static final String USER_DATA_ROOT_PATH= "D:/miniVedioData/";

    //每页最大显示的数据、
    public static final Integer MAX_PAGE_DATA_NUM  = 6;

    //redis Session 缓存的key前缀
    public static final String USER_REDIS_SESSION = "user_redis_session";
}
