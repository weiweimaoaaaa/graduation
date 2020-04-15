package com.commity.backmethod.result;

public class ResultFactory {
    public static Result buildSuccessResult(Object data) {//返回对象实体
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }
    public static Result buildFailResult(String message) {//返回失败信息
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }
    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
