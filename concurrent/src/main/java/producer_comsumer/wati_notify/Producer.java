package producer_comsumer.wati_notify;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{
    private Queue<Product> queue;
    private int maxCapacity;

    public Producer(Queue<Product> queue, int maxCapacity){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void run() {
        synchronized (queue){
            while (queue.size() == maxCapacity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (queue.size() == 0){
                queue.notifyAll();
            }
            Random random = new Random();
            Integer i = random.nextInt();
            queue.offer(new Product("产品："+i.toString()));
            System.out.println("生产者:"+Thread.currentThread().getName()+"生产了产品："+i.toString());
        }
    }
}
