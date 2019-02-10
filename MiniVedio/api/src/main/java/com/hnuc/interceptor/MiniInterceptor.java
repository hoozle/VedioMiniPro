package com.hnuc;

import com.hnuc.common.util.Constant;
import com.hnuc.common.util.JSONResult;
import com.hnuc.common.util.RedisUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Component
public class MiniInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 拦截请求，在controller调用之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userID = request.getHeader("userID");
        String userToken = request.getHeader("userToken");
        System.out.println("userID:" + userID);
        System.out.println("userToken:" + userToken);
        if(null != userID && null!= userToken &&
                (!StringUtils.isBlank(userID)) && (!StringUtils.isBlank(userToken))){
            String validToken = redisUtil.get(Constant.USER_REDIS_SESSION + ":" + userID);
            if(null == validToken ){
                pushBackErrorMsg(response, new JSONResult(502,"请登录！",null));
                return false;
            }else{
                if(!validToken.equals(userToken)) {
                    pushBackErrorMsg(response, new JSONResult(502, "账号被挤出！", null));
                    return false;
                }
            }
        }else{
            pushBackErrorMsg(response, new JSONResult(502,"请登录！",null));
            return false;
        }

        return true;
    }

    /**
     * 请求controller之后，渲染视图之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求controller之后，视图渲染之后 可用于清理资源等
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private  boolean pushBackErrorMsg(HttpServletResponse response, JSONResult jsonResult){
        if(null == response || null== jsonResult){
            return false;
        }

        PrintWriter printWriter = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            String resultString = JSONObject.fromObject(jsonResult).toString();
            if(null == resultString){
                return false;
            }
            printWriter = response.getWriter();
            printWriter.write(resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null == printWriter){
                printWriter.close();
            }
        }

        return true;
    }
}
