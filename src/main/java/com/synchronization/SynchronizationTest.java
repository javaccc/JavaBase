package com.synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizationTest {

    public static void main(String[] args) {
        List wordList = Collections.synchronizedList(new ArrayList());

    }
}
