import java.util.concurrent.*;

public class callable_demo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future submit = service.submit(new Callable() {
            public Object call() throws Exception {
                return "通过callable实现的多线程";
            }
        });
        try {
            Object o = submit.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(submit.isCancelled());
        service.shutdown();
    }
}
