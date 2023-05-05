package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private int n;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.offer("fizz");
            }
        }
    }

    public void buzz() {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                queue.offer("buzz");
            }
        }
    }

    public void fizzbuzz() {
        for (int i = 15; i <= n; i += 15) {
            queue.offer("fizzbuzz");
        }
    }

    public void number() {
        for (int i = 1; i <= n; i++) {
            String output = null;
            try {
                output = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (output == null) {
                System.out.println(i);
            } else {
                System.out.println(output);
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzzProgram = new FizzBuzz(15);

        Thread threadA = new Thread(() -> fizzBuzzProgram.fizz());
        Thread threadB = new Thread(() -> fizzBuzzProgram.buzz());
        Thread threadC = new Thread(() -> fizzBuzzProgram.fizzbuzz());
        Thread threadD = new Thread(() -> fizzBuzzProgram.number());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}