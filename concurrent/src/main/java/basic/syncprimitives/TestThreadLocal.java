package basic.syncprimitives;

public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("线程："+Thread.currentThread().getName()+"设置：hello"+Thread.currentThread().getName());
        String s = stringThreadLocal.get();
        System.out.println(s);
        stringThreadLocal.remove();
        Thread thread = new Thread(new newThread());
        thread.start();
    }

    static class newThread implements Runnable{
        ThreadLocal<String> local = new ThreadLocal<String>();
        @Override
        public void run() {
            String s = local.get();
            System.out.println(s);
        }
    }
}
