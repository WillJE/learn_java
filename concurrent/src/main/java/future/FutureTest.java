package future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> cookTask = new FutureTask<>(new Callable<String>(){
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "5斤的龙虾";
            }
        });

        long startTime = System.currentTimeMillis();

        System.out.println("我点了5斤的龙虾");
        new Thread(cookTask).start();

        System.out.println("我去买牙膏");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("我买到牙膏了");

        String launch = cookTask.get();
        System.out.println("我点的"+launch+"已经做好了");

        long costTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("我一共用了"+costTime+"秒来买午餐并且买牙膏");
    }
}
