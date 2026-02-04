package com.alex.d7_abstract_demo2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 具体子类：订单创建POST请求 - 原生HttpURLConnection实现
 */
public class OrderCreatePostRequest extends AbstractApiRequest {
    private String productId;
    private Integer num;

    public OrderCreatePostRequest(String productId, Integer num) {
        this.productId = productId;
        this.num = num;
    }

    @Override
    protected String getApiPath() {
        return "order/create";
    }

    @Override
    protected boolean checkParams() {
        return productId != null && !productId.trim().isEmpty() && num != null && num > 0;
    }

    // 🌟 核心：原生API实现POST请求（JSON传参）
    @Override
    protected String sendRequest(String fullUrl) throws Exception {
        URL url = new URL(fullUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置POST请求
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(3000);
        conn.setReadTimeout(3000);
        // 允许写入请求体
        conn.setDoOutput(true);
        // 设置请求头（JSON传参）
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

        // 构造JSON请求体
        String jsonBody = "{\"productId\":\"" + productId + "\",\"num\":" + num + "}";
        // 写入请求体
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.write(jsonBody.getBytes("UTF-8"));
        dos.flush();
        dos.close();

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

    // 解析响应字符串
    @Override
    protected Object parseResponse(String responseStr) {
        Map<String, Object> orderResult = new HashMap<>();
        orderResult.put("orderId", "ORD" + System.currentTimeMillis());
        orderResult.put("productId", productId);
        orderResult.put("status", "创建成功");
        orderResult.put("原生响应字符串", responseStr);
        return orderResult;
    }
}