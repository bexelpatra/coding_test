package com.test.TEST.ProxyTest;

public class MyProxy implements ProxyInterface {
    // private final ProxyInterfaceImpl proxyInterfaceImpl = new
    // ProxyInterfaceImpl();
    private final ProxyInterface proxyInterfaceImpl = new ProxyInterfaceImpl();

    @Override
    public String getString(String src) {
        // TODO Auto-generated method stub
        return proxyInterfaceImpl.getString(src);
    }

}
