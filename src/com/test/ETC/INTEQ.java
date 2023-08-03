package com.test.ETC;

public enum INTEQ {
    LT("<"),
    GT(">"),
    LTE("<="),
    GTE(">="),
    EQ("==");

    private String eq;

    private INTEQ(String eq) {
        this.eq = eq.toLowerCase();
    }

    public boolean compare(int src, int val) {
        if (this.eq.equals(">")) {
            return src > val;
        } else if (this.eq.equals("<")) {
            return src < val;
        } else if (this.eq.equals(">=")) {
            return src >= val;
        } else if (this.eq.equals("<=")) {
            return src <= val;
        } else if (this.eq.equals("==")) {
            return src == val;
        } else {
            return false;
        }
    }
}
