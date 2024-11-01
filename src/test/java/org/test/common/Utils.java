package org.test.common;

public class Utils {
    public static void sleep(int time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
