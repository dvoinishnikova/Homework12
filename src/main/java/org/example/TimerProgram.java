package org.example;

import java.util.concurrent.TimeUnit;
public class TimerProgram {
    public static void main(String[] args) {
        Thread timerThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Пройшло " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime) + " секунд");
                try {
                    Thread.sleep(1000); // Затримка на 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();

        Thread messageThread = new Thread(() -> {
            while (true) {
                System.out.println("Минуло 5 секунд");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        messageThread.start();
    }
}
