package com.example.asd.util;

public class Config {
    /**
     * 密码最小长度，默认为8
     */
    public static String MIN_LENGTH="8";
    /**
     * 密码最大长度，默认为20
     */
    public static String MAX_LENGTH="16";

    /**
     * 特殊符号集合
     */
    public static String SPECIAL_CHAR = "#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    /**
     * 密码口令中字符在逻辑位置上不允许最小的连续个数
     */
    public static String LIMIT_LOGIC_NUM_CHAR = "3";

    /**
     * 是否区分大小写
     */
    public static String CHECK_DISTINGGUISH_CASE = "disable";


    /**
     * 密码口令中相同字符不允许最小的连续个数
     */
    public static String LIMIT_NUM_SAME_CHAR = "3";

    /**
     * 键盘物理位置横向不允许最小的连续个数
     */
    public static String LIMIT_HORIZONTAL_NUM_KEY = "3";

    /**
     * 键盘横向方向规则
     */
    public static String[] KEYBOARD_HORIZONTAL_ARR = {
            "01234567890",
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm",
    };


}
