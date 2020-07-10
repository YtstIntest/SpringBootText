package com.example.asd.config;

import com.example.asd.common.ResponseBean;
import com.example.asd.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    //日志操作
    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    /**
     * 捕捉其他所有自定义异常
     *
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public ResponseBean handle(CustomException e) {
//        logger.error("捕捉其他所有自定义异常:" + e.getMessage(), e);
        return new ResponseBean(0, e.getMessage(), null);
    }
}
