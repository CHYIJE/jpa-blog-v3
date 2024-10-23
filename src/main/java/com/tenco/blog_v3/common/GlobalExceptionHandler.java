package com.tenco.blog_v3.common;

import com.tenco.blog_v3.common.Utils.ApiUtil;
import com.tenco.blog_v3.common.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// 데이터 반환
@RestControllerAdvice  // IoC 대상 ( 뷰 렌더링)
public class GlobalExceptionHandler {

    // 400 에러 처리 = return - json
    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> handleException400(Exception400 e) {

        ApiUtil<?> apiUtil = new ApiUtil<>(400, e.getMessage());

        return new ResponseEntity<>(apiUtil, HttpStatus.BAD_REQUEST);
    }

    // 401 에러 처리 = return - json
    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> handleException401(Exception401 e) {

        ApiUtil<?> apiUtil = new ApiUtil<>(401, e.getMessage());

        return new ResponseEntity<>(apiUtil, HttpStatus.UNAUTHORIZED);
    }

    // 403 에러 처리 = return - json
    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> handleException403(Exception403 e) {

        ApiUtil<?> apiUtil = new ApiUtil<>(403, e.getMessage());

        return new ResponseEntity<>(apiUtil, HttpStatus.FORBIDDEN);
    }

    // 404 에러 처리 = return - json
    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> handleException404(Exception404 e) {

        ApiUtil<?> apiUtil = new ApiUtil<>(404, e.getMessage());

        return new ResponseEntity<>(apiUtil, HttpStatus.NOT_FOUND);
    }

    // 500 에러 처리 = return - json
    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> handleException500(Exception500 e) {

        ApiUtil<?> apiUtil = new ApiUtil<>(500, e.getMessage());

        return new ResponseEntity<>(apiUtil, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
