package com.example.asd.config.jwt;


import com.example.asd.common.constant.Constant;
import com.example.asd.config.ExceptionAdvice;
import com.example.asd.config.redis.JedisUtil;
import com.example.asd.exception.CustomException;
import com.example.asd.util.common.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    //日志操作
    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 如果打上了AuthToken注解则需要验证token
        if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {
            String token = request.getHeader(httpHeaderName);
            logger.info(token);
            Object username = "";
            if (StringUtils.isNotEmptyStr(token)) {
                username = JedisUtil.getObject(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token);
                logger.info("username is {}", username);
                if (username != null) {
                    Long haveTime=JedisUtil.ttl(Constant.PREFIX_SHIRO_CACHE + username + token);
                    if(haveTime<Constant.EXRP_HOUR){
                        JedisUtil.setObject(Constant.PREFIX_SHIRO_CACHE + username, token, Constant.EXRP_DAY);
                        JedisUtil.setObject(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token, username, Constant.EXRP_DAY);
                    }
                } else {
                    throw new CustomException("Token不合法(Token Failure)");
                }
            } else {
                throw new CustomException("未获取到有效Token(Token Failure)");
            }
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
