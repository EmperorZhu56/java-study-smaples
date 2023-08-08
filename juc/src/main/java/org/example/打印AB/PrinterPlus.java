package org.example.打印AB;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 打印机
 *
 * @author zhu56
 * @date 2023/08/08 23:06
 */
public class PrinterPlus {

    private Integer flag = 1;

    public void printA() throws InterruptedException {
        synchronized (this) {
            while (!Objects.equals(flag,1)) {
                wait();
            }
            flag = 2;
            System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), "A"));
            Thread.sleep(500);
            notifyAll();
        }
    }

    public void printB() throws InterruptedException {
        synchronized (this) {
            while (!Objects.equals(flag,2)) {
                wait();
            }
            flag = 3;
            System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), "B"));
            Thread.sleep(500);
            notifyAll();
        }
    }

    public void printC() throws InterruptedException {
        synchronized (this) {
            while (!Objects.equals(flag,3)) {
                wait();
            }
            flag = 1;
            System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), "C"));
            Thread.sleep(500);
            notifyAll();
        }
    }
}
