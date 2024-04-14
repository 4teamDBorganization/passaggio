package com.passaggio.project.delay;

public class Delay {
    public static void countdelay(int waitseconds) {
        try {
            Thread.sleep(waitseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //System.err.println("Interrupted: " + e.getMessage());
            //로그
        }
    }
}

