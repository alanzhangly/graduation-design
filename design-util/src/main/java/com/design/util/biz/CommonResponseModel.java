package com.design.util.biz;


import com.design.util.exception.ReturnCodeModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ke Zhang on 2018/3/5.
 */
public class CommonResponseModel {

    Map _data;

    public CommonResponseModel(ReturnCodeModel code, Map data) {
        if(data==null){
            data=new HashMap();
        }

        data.put("errCode", code.getCode());
        data.put("errMsg", code.getMsg());


        this._data = data;
    }


    public Map get_data() {
        return _data;
    }

    public static Map facade(ReturnCodeModel code, Map data) {
        return new CommonResponseModel(code, data).get_data();
    }

    public static Map facade(ReturnCodeModel code) {
        return new CommonResponseModel(code, null).get_data();
    }

    public static Map success(Map data) {


        return new CommonResponseModel(ReturnCodeModel.SUCCESS, data).get_data();
    }

    public static Map success() {
        return new CommonResponseModel(ReturnCodeModel.SUCCESS, null).get_data();
    }

    public static Map fail(Map data) {
        return new CommonResponseModel(ReturnCodeModel.FAIL, data).get_data();
    }

    public static Map fail() {
        return new CommonResponseModel(ReturnCodeModel.FAIL, null).get_data();
    }


    @Override
    public String toString() {
        return _data.toString();
    }

}
