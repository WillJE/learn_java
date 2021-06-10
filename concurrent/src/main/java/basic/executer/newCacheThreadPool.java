package basic.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newCacheThreadPool {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //向线程池提交任务
        for (int i = 0; i < 50 ; i++){
            service.execute(new Task());
        }
        service.shutdown();
    }
}
