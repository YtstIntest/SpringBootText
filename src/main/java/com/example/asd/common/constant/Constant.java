package com.example.asd.common.constant;

public class Constant {


    /**
     * redis-OK
     */
    public final static String OK = "OK";

    /**
     * redis过期时间，以秒为单位，一分钟
     */
    public final static int EXRP_MINUTE = 60;

    /**
     * redis过期时间，以秒为单位，一小时
     */
    public final static int EXRP_HOUR = 60 * 60;

    /**
     * redis过期时间，以秒为单位，一天
     */
    public final static int EXRP_DAY = 60 * 60 * 24;

    /**
     * redis-key-前缀-shiro:cache:
     */
    public final static String PREFIX_SHIRO_CACHE = "shiro:cache:";

    /**
     * redis-key-前缀-shiro:access_token:
     */
    public final static String PREFIX_SHIRO_ACCESS_TOKEN = "shiro:access_token:";

    /**
     * redis-key-前缀-shiro:refresh_token:
     */
    public final static String PREFIX_SHIRO_REFRESH_TOKEN = "shiro:refresh_token:";

    /**
     * JWT-account:
     */
    public final static String ACCOUNT = "account";

    /**
     * JWT-currentTimeMillis:
     */
    public final static String CURRENT_TIME_MILLIS = "currentTimeMillis";

    /**
     * PASSWORD_MAX_LEN
     */
    public static final Integer PASSWORD_MAX_LEN = 8;

    /**
     * redis-key-前缀-TOTAL:USER_LIKE:COUNT::
     */
    public final static String PREFIX_USER_TOTAL_LIKE_COUNT = "total:user_like:count:";

    /**
     * redis-key-前缀-USER:LIKE:SUBJECT:
     */
    public final static String PREFIX_USER_LIKE_SUBJECT = "user:like:subject:";
    /**
     * redis-key-前缀-SUBJECT:LIKED:USER:
     */
    public final static String PREFIX_SUBJECT_LIKED_USER = "subject:liked:user:";

    /**
     * redis-key-前缀-sms:login:phone:
     */
    public final static String PREFIX_SMS_LOGIN_PHONE = "sms:login:phone:";

    /**
     * 手机号正则表达式
     */
    public final static String REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9])|(16[6]))\\d{8}$";

}
