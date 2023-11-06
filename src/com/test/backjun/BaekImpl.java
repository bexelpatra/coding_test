package com.test.backjun;

import java.io.BufferedReader;

public interface BaekImpl<E> {
    E getResult(BufferedReader reader) throws Exception;
}
