import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class blockingQueue_demo {
     class Producer implements Runnable{
        private BlockingDeque<Integer> queue;
        Producer(blockingQueue_demo queue) {
            this.queue = (BlockingDeque<Integer>) queue;
        }
        @Override
        public void run() {
            queue.offer(new Random().nextInt(100));
        }
    }
}
