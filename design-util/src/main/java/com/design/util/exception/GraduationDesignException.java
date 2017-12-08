package com.design.util.exception;

/**
 * Created by Ke Zhang on 2017/11/13.
 * 统一异常管理
 */
public class GraduationDesignException extends DesignCommonException {

    private ReturnCodeModel exception_type;

    public GraduationDesignException(String msg){
        super(msg);
    }
    public GraduationDesignException(ReturnCodeModel type){
        this(type.getMsg());
        this.exception_type = type;
    }
    public String getErrorMsg(){
        return this.exception_type.getMsg();
    }
    public String getErrorCode(){
        return this.exception_type.getCode();
    }

    public ReturnCodeModel getException_type() {
        return exception_type;
    }
}
