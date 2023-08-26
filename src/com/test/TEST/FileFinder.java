package com.test.TEST;

import java.io.File;

public class FileFinder {
    public static final String key = "mobileRestServer";

    public static void main(String[] args) {
        String root = "c:/";
        File rf = new File(root);
        loop(rf);
    }

    public static void loop(File file) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list == null) {
                return;
            }
            for (int i = 0; i < list.length; i++) {
                File inner = list[i];
                if (inner.getName().contains(key)) {
                    System.out.println(inner.getAbsolutePath());
                    return;
                } else {
                    if (inner != null) {
                        loop(inner);
                    }
                }

            }

        }
    }
}
