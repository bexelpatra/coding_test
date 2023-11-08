package com.test.TEST.ProxyTest;

public class ProxyInterfaceImpl implements ProxyInterface {

    @Override
    public String getString(String src) {
        // TODO Auto-generated method stub
        return new StringBuilder().append(src).append(" this is what you inputed").toString();
    }
}
