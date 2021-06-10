package producer_comsumer.wati_notify;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Product> queue;
    private int maxCapacity;

    public Consumer(Queue<Product> queue, int maxCapacity){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void run() {
        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (queue.size() == maxCapacity){
                notifyAll();
            }
            Product poll = queue.poll();
            System.out.println("消费者:"+Thread.currentThread().getName()+"消费了产品："+poll.getName());
        }
    }
}
