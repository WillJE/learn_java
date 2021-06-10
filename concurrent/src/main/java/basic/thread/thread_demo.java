package basic.thread;

public class thread_demo {
    public static void main(String[] args) {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        System.out.println("主线程名称："+Thread.currentThread().getName());
        MyThread_test  thread1 = new MyThread_test ("thread 1");
        thread1.start();
    }
}

class MyThread_test  extends Thread{
    private String name;
    public MyThread_test (String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}

