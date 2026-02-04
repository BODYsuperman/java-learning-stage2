package com.alex.d7_abstract_demo2;

public class ApiRequestTest {
    public static void main(String[] args) {
        // 查询用户信息
        System.out.println("===== 查询用户信息 =====");
        AbstractApiRequest userRequest = new UserInfoGetRequest("1001");
        userRequest.doRequest();

        // 创建订单
        System.out.println("\n===== 创建订单 =====");
        AbstractApiRequest orderRequest = new OrderCreatePostRequest("PROD001", 2);
        orderRequest.doRequest();

        // 测试参数校验失败
        System.out.println("\n===== 测试参数校验失败 =====");
        AbstractApiRequest badRequest = new UserInfoGetRequest(null);
        badRequest.doRequest();
    }
}
