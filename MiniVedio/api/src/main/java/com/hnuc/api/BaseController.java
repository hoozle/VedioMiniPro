package com.hnuc.api;

import com.hnuc.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected RedisUtil redisUtil;

    protected static final String USER_REDIS_SESSION = "user_redis_session";
}
