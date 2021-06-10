package basic.runnable;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("小齐666：" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.join();

        for(int i = 0; i < 100; i++) {
            System.out.println("主线程" + i + "：齐姐666");
        }
    }
}
