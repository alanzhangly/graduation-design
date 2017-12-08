package com.design.util.exception;

/**
 * Created by Ke Zhang on 2017/11/13.
 */
public enum ReturnCodeModel {

    SUCCESS("9999","执行成功"),
    RPC_ERROR("0000","RPC请求失败"),
    PARAMETER_MISS("0001","参数缺失"),
    IDCARD_ERROR("0002", "身份证格式错误"),
    TOKEN_ERROR("0003", "无效token"),
    TOKEN_MISS("0004", "token缺失"),
    ;
    private String code;
    private String msg;
    private ReturnCodeModel(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private ReturnCodeModel(){}

    public String getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }
    public static ReturnCodeModel getByCode(String code){
        for(ReturnCodeModel param : ReturnCodeModel.values()){
            if(param.getCode().equals(code)){
                return param;
            }
        }
        return null;
    }
}
