package com.pb.kozina.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class manufacturer {
    static class Consumer implements Runnable {

        private final Queue<Double> data;

        public Consumer(Queue<Double> data) {
            this.data = data;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    synchronized (data) {
                        if (data.isEmpty()) {
                            System.out.println("Consumer ожидает генерации данных...");
                            data.wait();
                        } else {
                            System.out.println("Получены данные: " + data.poll());
                            data.notify();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Produce implements Runnable {

        private final Queue<Double> data;
        private final int size;

        public Produce(Queue<Double> data, int size) {
            this.data = data;
            this.size = size;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    synchronized (data) {
                        if (data.size() >= size) {
                            System.out.println("Produce ожидает освобождения буфера consumer...");
                            data.wait();
                        } else {
                            Double newValue =  Math.random();
                            data.add(newValue);
                            data.notify();
                            System.out.println("Сгенерены данные: " + newValue);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Queue<Double> data = new LinkedList<>();
        int size = 5;
        Thread produceThread = new Thread(new Produce(data, size), "Produce");
        Thread consumerThread = new Thread(new Consumer(data), "Consumer");
        produceThread.start();
        consumerThread.start();

        Thread.sleep(100);

        produceThread.interrupt();
        consumerThread.interrupt();

    }
}
