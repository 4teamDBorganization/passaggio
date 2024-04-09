package com.passaggio.project.signup;

public class Timer {
    public static void wait(int waitseconds) {
        try {
            Thread.sleep(waitseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //System.err.println("Interrupted: " + e.getMessage());
            //로그
        }
    }
}

