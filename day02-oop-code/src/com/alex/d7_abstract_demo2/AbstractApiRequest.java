package com.alex.d7_abstract_demo2;

/**
 * 接口请求抽象模版类 - 移除Hutool依赖，适配原生API
 */
public abstract class AbstractApiRequest {
    // 固定域名
    private static final String BASE_URL = "https://api.example.com/";

    // 🌟 模版方法：核心流程不变
    public final Object doRequest() {
        Object result = null;
        try {
            if (!checkParams()) {
                throw new IllegalArgumentException("请求参数校验失败！");
            }
            String fullUrl = buildUrl(); // 固定步骤：拼接URL
            String responseStr = sendRequest(fullUrl); // 原生请求返回字符串
            result = parseResponse(responseStr); // 解析字符串响应
            handleResponse(result); // 固定步骤：处理响应
        } catch (Exception e) {
            handleException(e); // 固定步骤：处理异常
        }
        return result;
    }

    // 固定步骤：拼接完整URL
    private String buildUrl() {
        return BASE_URL + getApiPath();
    }

    // 固定步骤：统一处理响应
    private void handleResponse(Object result) {
        System.out.println("接口请求成功，响应结果：" + result);
    }

    // 固定步骤：统一处理异常
    private void handleException(Exception e) {
        System.err.println("接口请求失败，异常信息：" + e.getMessage());
        throw new RuntimeException("接口请求异常", e);
    }

    // 抽象方法（核心不变，仅sendRequest返回值调整）
    protected abstract String getApiPath();
    protected abstract boolean checkParams();
    // 原生请求：返回响应字符串，不再依赖Hutool
    protected abstract String sendRequest(String fullUrl) throws Exception;
    // 解析字符串响应
    protected abstract Object parseResponse(String responseStr);
}
