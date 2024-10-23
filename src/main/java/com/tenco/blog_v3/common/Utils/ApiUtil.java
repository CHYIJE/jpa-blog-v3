package com.tenco.blog_v3.common.Utils;

import lombok.Data;

@Data
public class ApiUtil<T> {

    private Integer status; // 협의 1. 성공 -1 실패
    private String msg;
    private T body;

    public ApiUtil(T body) {
        this.status = 200;
        this.msg = "성공";
        this.body = body;
    }

    public ApiUtil(Integer status, String msg) {
        this.status = 400;
        this.msg = "실패";
        this.body = null;
    }

}
