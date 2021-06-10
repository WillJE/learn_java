package basic.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        int thread_nums = 10;
        ExecutorService service = Executors.newFixedThreadPool(thread_nums);

        for (int i = 0; i < 200; i++){
            service.execute(new Task());
        }
        service.shutdown();
    }
}
