package com.test.TEST;

// import org.junit.Assert.assertEquals;

// import org.junit.Test;

public class NonPrimitiveTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Clazz a = new Clazz(1);
        Clazz b = new Clazz(3);
        // assertEquals(1, 1);
        // 수정 전
        // assertEquals(a.member, 1);
        // assertEquals(b.member, 1);
        System.out.println(a.member == 1);
        System.out.println(b.member == 1);
        modify(a, b);
        System.out.println(a.member == 2);
        System.out.println(b.member == 3);
        // 수정 후
        // assertEquals(a.member, 2);
        // assertEquals(b.member, 1);
    }

    public static void modify(Clazz a1, Clazz b1) {
        a1.member++;

        b1 = new Clazz(1);
        b1.member++;
        System.out.println("inner" + b1.member);
    }

}

class Clazz {
    public int member;

    public Clazz(int num) {
        this.member = num;
    }
}