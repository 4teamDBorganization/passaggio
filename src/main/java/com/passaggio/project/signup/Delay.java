package com.passaggio.project.signup;

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

