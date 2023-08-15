package org.example.多线程;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);


        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(new Random().nextInt((5000 - 1000) + 1) + 1000);
                    System.out.println(MessageFormat.format("{0}完成第{1}步骤", Thread.currentThread().getName(), i + 1));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(new Random().nextInt((5000 - 1000) + 1) + 1000);
                    System.out.println(MessageFormat.format("{0}完成第{1}步骤", Thread.currentThread().getName(), i + 1));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(new Random().nextInt((5000 - 1000) + 1) + 1000);
                    System.out.println(MessageFormat.format("{0}完成第{1}步骤", Thread.currentThread().getName(), i + 1));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
