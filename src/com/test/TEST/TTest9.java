package com.test.TEST;

import java.util.HashMap;
import java.util.Map;

public class TTest9 {
    static class Foo {

    private int value;

    public Foo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

// 메소드에서 개체를 변격할수 있지만 새롭게 객체 자체를 변경할 수는 없다.
    public static void main(String[] args) {
        Foo foo = new Foo(7);
        System.out.println(foo.getValue());
        process(foo);
        System.out.println(foo.getValue());
        // Map<String,String> map=null;
        // map(map);
        // System.out.println(map);
        Map<Integer,Byte> map = new HashMap<>();
        int idx = 500;
        while(idx -->-500){
            map.put(idx, (byte)idx);
            if((byte)idx <0){
            }
        }
        for (int ke : map.keySet()) {
            System.out.println(ke + " : "+ map.get(ke));
        }
    }

    public static void map(Map<String,String> map){
        map = new HashMap<>();
        map.put("a", "b");
    }
    public static void process(Foo foo) {
        // 주소 값을 통해 필드 값을 변경
        foo.setValue(10);

        // 객체 자체를 변경하는 것은 영향 X
        foo = new Foo(15);
    }


}
