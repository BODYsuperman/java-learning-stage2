package com.alex.d7_abstract_demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 具体子类：用户查询GET请求 - 原生HttpURLConnection实现
 */
public class UserInfoGetRequest extends AbstractApiRequest {
    private String userId;

    public UserInfoGetRequest(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiPath() {
        return "user/get";
    }

    @Override
    protected boolean checkParams() {
        return userId != null && !userId.trim().isEmpty();
    }

    // 🌟 核心：原生API实现GET请求
    @Override
    protected String sendRequest(String fullUrl) throws Exception {
        // 拼接GET参数
        String param = "userId=" + URLEncoder.encode(userId, "UTF-8");
        String fullUrlWithParam = fullUrl + "?" + param;

        // 打开连接
        URL url = new URL(fullUrlWithParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置请求方式
        conn.setRequestMethod("GET");
        // 设置超时
        conn.setConnectTimeout(3000);
        conn.setReadTimeout(3000);

        // 读取响应
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        conn.disconnect();

        return sb.toString();
    }

    // 解析响应字符串（模拟，实际可解析JSON）
    @Override
    protected Object parseResponse(String responseStr) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("userName", "张三");
        userInfo.put("age", 25);
        userInfo.put("原生响应字符串", responseStr);
        return userInfo;
    }
}