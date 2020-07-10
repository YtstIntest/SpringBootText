package com.example.asd.config.helper;

import com.example.asd.common.enums.ErrorCode;
import com.example.asd.exception.CustomException;
import com.example.asd.util.ReflectUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ValidateHelper {
    /**
     * 通用非空参数校验
     *
     * @return 返回校验信息
     */
    public static void validateNull(Object bean, String[] propertyNames) {
        StringBuffer errorMessage = new StringBuffer();

        if (bean == null) {
            throw new CustomException(ErrorCode.PARAMETER_ERROR.getMessage());
        }

        // 不需要校验参数
        if (propertyNames == null || propertyNames.length == 0) {
            return;
        }

        for (String name : propertyNames) {
            Object value = ReflectUtil.getValue(bean, name);
            if (null == value || "".equals(value)) {
                errorMessage.append("[").append(name).append("]不能为空;");
            }
        }

        if (errorMessage.length() > 0) {
            throw new CustomException(ErrorCode.PARAMETER_ERROR.getCode(), errorMessage.toString());
        }
    }

    public static boolean isEmptyObject( Object object ){
        if(object == null) return true;
        if(object instanceof String ){
            return "".equals(object.toString());
        }
        else if( object instanceof Collection<?>){
            return ((Collection<?>)object).isEmpty();
        }
        else if( object instanceof Object[] ){
            return ((Object[])object).length == 0;
        }
        else if( object instanceof Map<?, ?>){
            return ((Map<?,?>)object).isEmpty();
        }
        return false;
    }

    /**
     * 校验列表
     *
     * @author NIck
     * @since 2020年1月7日
     * @param beanList
     * @param properties
     */
    public static void validateNullList(List<?> beanList, String[] properties) {
        if (isEmptyObject(beanList)) {
            throw new CustomException(ErrorCode.PARAMETER_ERROR.getCode(), "请求参列表象不能为空.");
        }

        for (Object bean : beanList) {
            validateNull(bean, properties);
        }
    }
}
