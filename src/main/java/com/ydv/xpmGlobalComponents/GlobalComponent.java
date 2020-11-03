package com.ydv.xpmGlobalComponents;

import com.ydv.xpm.Data;

public class GlobalComponent {

    private Number status_code;
    private String status;

     private Data data;
    private String code;
    private String message;



    public Number getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Number status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.ydv.xpm.Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
