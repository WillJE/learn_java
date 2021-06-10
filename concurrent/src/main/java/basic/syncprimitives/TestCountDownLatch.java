package basic.syncprimitives;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * http://ckjava.com/2018/09/13/JUC-CountDownLatch-understand-practice/
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++){
            service.submit(new WorkerRunner(Integer.toString(i),countDownLatch));
        }
        System.out.println("Main thread running....");
        countDownLatch.await();
        System.out.println("Main thread finish");
        service.shutdown();
    }

    public static class WorkerRunner implements Runnable{
        private String runnerName;
        private CountDownLatch countDownLatch;

        public WorkerRunner(String runnerName,CountDownLatch countDownLatch){
            this.runnerName = runnerName;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                System.out.printf("Worker %s is working....\n",this.runnerName);
                TimeUnit.SECONDS.sleep(2);
                System.out.printf("Worker %s is done....\n",this.runnerName);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
