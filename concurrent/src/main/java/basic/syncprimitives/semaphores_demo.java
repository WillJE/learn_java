package basic.syncprimitives;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * https://moonto.org/java-primitive-mutex-semaphore.html
 */
public class semaphores_demo {
    private static final Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(semaphores_demo::execute);
        service.submit(semaphores_demo::execute);
        service.submit(semaphores_demo::execute);
        TimeUnit.SECONDS.sleep(3);
        service.shutdown();
    }

    private static void execute(){
        try {
            semaphore.acquire();
            System.out.printf("线程%s获取到锁\n",Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("线程%s释放锁\n",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
