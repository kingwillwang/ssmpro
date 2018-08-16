package com.will.common;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMessage(Constants.DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMessage(Constants.DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(Constants.RESULT_CODE_SERVER_ERROR);
        if (message == null || message.length() < 1) {
            message = Constants.DEFAULT_SUCCESS_MESSAGE;
        }
        result.setMessage(message);
        return result;
    }

    public static Result genBadResult(String message) {
        Result result = new Result();
        result.setCode(Constants.RESULT_CODE_BAD_REQUEST);
        if (message == null || message.length() < 1) {
            message = Constants.DEFAULT_SUCCESS_MESSAGE;
        }
        result.setMessage(message);
        return result;
    }

}
