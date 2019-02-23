package com.sjl.learn.result;

import com.sjl.learn.entity.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorInfoHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorInfoHandler.class.getName());

    @ExceptionHandler(value = Exception.class)
    public BaseResponse errorHandler(HttpServletRequest request, Exception exception) {
        logger.error(request.getRequestURI() + "," + exception.getMessage());
        return new BaseResponse<String>(0,exception.getMessage(),null);
    }
}
