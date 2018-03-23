package com.design.util.exception;

/**
 * Created by Ke Zhang on 2017/11/13.
 */
public enum ReturnCodeModel {

    SUCCESS("9999","执行成功"),
    FAIL("0000", "系统异常"),
    RPC_ERROR("0002","RPC请求失败"),
    PARAMETER_MISS("0003","参数缺失"),
    IDCARD_ERROR("0004", "身份证格式错误"),
    TOKEN_ERROR("0005", "无效token"),
    TOKEN_MISS("0006", "token缺失"),
    EXCEL_READ_ERROR("0007", "excel读取错误"),
    EXCEL_DATA_ERROR("0008", "excel数据有误"),
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
