class Device implements Runnable {
    String name;
    int interval;

    Device(String name, int interval) {
        this.name = name;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " running at " + System.currentTimeMillis());

            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thread security = new Thread(new Device("Security Camera", 3));
        Thread temp = new Thread(new Device("Temperature Sensor", 5));
        Thread light = new Thread(new Device("Light Controller", 4));
        Thread door = new Thread(new Device("Door Lock", 6));

        security.setPriority(10);
        temp.setPriority(7);
        light.setPriority(5);
        door.setPriority(5);

        security.start();
        temp.start();
        light.start();
        door.start();
    }
}