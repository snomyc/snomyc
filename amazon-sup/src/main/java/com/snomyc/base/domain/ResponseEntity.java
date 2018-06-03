package com.snomyc.base.domain;

import java.util.Map;

/**
 * 
 * 类名称：Response<br>
 * 类描述：Response 类<br>
 * @version v1.0
 *
 */
public class ResponseEntity {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String status;
    private String code;
    private String msg;
    private Object data;

    public ResponseEntity success() {
        this.status = SUCCESS;
        this.msg = "成功";
        this.code = ResponseConstant.CODE_999;
        return this;
    }

    public ResponseEntity success(String msg) {
        this.status = SUCCESS;
        this.msg = msg;
        this.code = ResponseConstant.CODE_999;
        return this;
    }

    public ResponseEntity success(String code, String msg) {
        this.status = SUCCESS;
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseEntity success(Map<String, Object> data, String msg) {
        this.status = SUCCESS;
        this.code = ResponseConstant.CODE_999;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseEntity success(Object data, String msg) {
        this.status = SUCCESS;
        this.code = ResponseConstant.CODE_999;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseEntity success(String code, String msg, Map<String, Object> data) {
        this.status = SUCCESS;
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseEntity failure(String code, String msg) {
        this.status = ERROR;
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseEntity failure(String msg) {
        this.status = ERROR;
        this.code = ResponseConstant.CODE_000;
        this.msg = msg;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public class ResponseData {
        private Map<String, Object> data;

        public ResponseData() {
            super();
        }

        public ResponseData(Map<String, Object> data) {
            super();
            this.data = data;
        }

        public Map<String, Object> getData() {
            return data;
        }

        public void setData(Map<String, Object> data) {
            this.data = data;
        }
    }

}
