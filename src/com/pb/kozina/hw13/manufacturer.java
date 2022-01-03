package com.pb.kozina.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class manufacturer {
    static class Consumer implements Runnable {

        private final Queue<Double> sharedQueue;

        public Consumer(Queue<Double> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    System.out.println("Consumed: " + consume());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        }

        // Метод, извлекающий элементы из общей очереди
        private Double consume() throws InterruptedException {
            synchronized (sharedQueue) {
                if (sharedQueue.isEmpty()) { // Если пуста, надо ждать
                    System.out.println("Consumer waiting...");
                    // освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
                    // пока другой поток не вызовет метод notify() или notifyAll()
                    sharedQueue.wait();
                }

                sharedQueue.notifyAll();
                return sharedQueue.poll();
            }
        }
    }

    static class Produce implements Runnable {

        private final Queue<Double> sharedQueue;
        private final int size;

        public Produce(Queue<Double> sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.size = size;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    // В цикле вызывается метод produce
                    System.out.println("Produced: " + produce());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        private double produce() throws InterruptedException {
            synchronized (sharedQueue) { // обязательно synchronized
                if (sharedQueue.size() >= size) {
                    // Если очередь полна, то ждём
                    System.out.println("Producer waiting...");
                    // освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
                    // пока другой поток не вызовет метод notify() или notifyAll()
                    sharedQueue.wait();
                }

                // Добавили элемент в очередь.
                double newValue = Math.random();
                sharedQueue.add(newValue);

                // Уведомили другой поток на случай, если он ждет
                sharedQueue.notifyAll();

                return newValue;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        LinkedList<Double> sharedQueue = new LinkedList<>();
        int size = 4;
        Thread prodThread = new Thread(new Produce(sharedQueue, size), "Produce");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();

        Thread.sleep(100);

        prodThread.interrupt();
        consThread.interrupt();
    }
}
