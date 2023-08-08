package org.example.打印AB;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Main {
    public static void main(String[] args) {


//        printAB();
        printABC();
    }

    public static void printAB() {

        Printer  printer = new Printer ();

        new Thread(() -> {
            while (true) {
                try {
                    printer.printA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "线程1").start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.printB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程2").start();


    }
    public static void printABC() {

        PrinterPlus printer = new PrinterPlus();

        new Thread(() -> {
            while (true) {
                try {
                    printer.printA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "线程1").start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.printB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程2").start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.printC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程3").start();
    }

}