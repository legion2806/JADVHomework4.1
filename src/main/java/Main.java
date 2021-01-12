
public class Main {

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenter = new CallCenter();

        Thread atc = new Thread(null, callCenter::workATC, "АТС");

        Thread pro1 = new Thread(null, callCenter::workPro, "Специалист 1");
        Thread pro2 = new Thread(null, callCenter::workPro, "Специалист 2");
        Thread pro3 = new Thread(null, callCenter::workPro, "Специалист 3");

        atc.start();

        pro1.start();
        pro2.start();
        pro3.start();

        atc.join();

        pro1.join();
        pro2.join();
        pro3.join();

    }
}