package com.alex.d1_inetAddress;

import java.net.InetAddress;

public class InetAddressDemo1 {

    public static void main(String[] args) throws Exception {

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());

        InetAddress byAddress = InetAddress.getByName("www.google.com");
        System.out.println(byAddress.getHostAddress());
        System.out.println(byAddress.getHostName());

        System.out.println(byAddress.isReachable(5000));


    }
}
