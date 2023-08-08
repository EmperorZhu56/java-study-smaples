package org.example.打印AB;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 打印机
 *
 * @author zhu56
 * @date 2023/08/08 23:06
 */
public class Printer {

    private Boolean flag = true;

    public void printA() throws InterruptedException {
        synchronized (this) {
            while (!flag) {
                wait();
            }
            flag = false;
            System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), "A"));
            Thread.sleep(500);
            notifyAll();
        }
    }

    public void printB() throws InterruptedException {
        synchronized (this) {
            while (flag) {
                wait();
            }
            flag = true;
            System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), "B"));
            Thread.sleep(500);
            notifyAll();
        }
    }
}
