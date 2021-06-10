package producer_comsumer.wati_notify;

import java.util.ArrayDeque;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Product> queue = new ArrayDeque<>();

        for(int i = 0; i < 100; i++){
            new Thread(new Producer(queue,100)).start();
            new Thread(new Consumer(queue,100)).start();
        }
    }
}
