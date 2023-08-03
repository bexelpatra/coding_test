package com.test.ETC;

import java.lang.reflect.Method;

public enum STRINGEQ {

    CONTAIN("contains", CharSequence.class),
    EQUALS("equals", Object.class),
    STARTWITH("startsWith", String.class),
    ENDWITH("endsWith", String.class),
    ;

    private String eq;
    private Class param;

    private STRINGEQ(String eq, Class param) {
        this.eq = eq;
        this.param = param;
    }

    public boolean compare(Object src, Object val) throws Exception {
        Method method = String.class.getMethod(eq, param);
        boolean flag = false;
        try {
            Object result = method.invoke(src, val);
            if (result != null) {
                return ((boolean) method.invoke(src, val));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        return flag;
    }
}
