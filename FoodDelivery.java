class Order implements Runnable {
    int orderId;
    String restaurant;
    int deliveryTime;

    Order(int id, String res, int time) {
        this.orderId = id;
        this.restaurant = res;
        this.deliveryTime = time;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        long start = System.currentTimeMillis();

        System.out.println("Order " + orderId + " picked up by " + t.getName());

        try {
            Thread.sleep(deliveryTime * 1000);
            System.out.println("Order " + orderId + " In Transit...");
            Thread.sleep(deliveryTime * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Order " + orderId + " Delivered by " + t.getName() +
                " | Time: " + (end - start) + " ms");
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Thread o1 = new Thread(new Order(1, "KFC", 2), "Agent-1");
        Thread o2 = new Thread(new Order(2, "Dominos", 3), "Agent-2");
        Thread o3 = new Thread(new Order(3, "Burger King", 1), "Agent-3");
        Thread o4 = new Thread(new Order(4, "Pizza Hut", 4), "Agent-4");
        Thread o5 = new Thread(new Order(5, "McDonalds", 2), "Agent-5");

        o1.setPriority(10);
        o2.setPriority(5);
        o3.setPriority(3);
        o4.setPriority(5);
        o5.setPriority(3);

        o1.start();
        o2.start();
        o3.start();
        o4.start();
        o5.start();
    }
}