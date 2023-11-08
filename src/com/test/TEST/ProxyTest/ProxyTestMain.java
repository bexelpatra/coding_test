package com.test.TEST.ProxyTest;

//https://esoongan.tistory.com/180
public class ProxyTestMain {
    public static void main(String[] args) {
        ProxyInterface interface1 = new MyProxy();
        System.out.println(interface1.getString("123"));
    }
}
