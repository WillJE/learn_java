package basic.syncprimitives;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 *http://static.kancloud.cn/oliver_lin/java-thread/1889686
 */
public class TestCycleBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () ->{
            System.out.println("人满了发车");
        });

        IntStream.range(1, 11).forEach(number -> {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(() ->{
                System.out.printf("第%d位乘客上车了\n",number);
                try {
                    cyclicBarrier.await();
                    System.out.printf("第%d位乘客出发了\n",number);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }

}
