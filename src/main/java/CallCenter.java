import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    public ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    int callMax = 10;
    int iterrtion = 0;

    public void workATC() {
        try {
            for (iterrtion = 0; iterrtion <= (callMax); iterrtion++) {
                String call = "запрос " + iterrtion;
                queue.add(call);
                System.out.printf("%s добавил в очередь %s\n", Thread.currentThread().getName(), call);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void workPro() {
        try {
            while (true) {
                Thread.sleep(3000);
                if (queue.isEmpty()) {
                    break;
                }
                else {
                    if (queue != null) {
                        System.out.printf("%s обработал %s\n", Thread.currentThread().getName(), queue.poll());
                    } else {
                        break;
                    }
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

}