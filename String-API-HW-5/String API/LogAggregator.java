class LogAggregator {

    static StringBuffer logBuffer = new StringBuffer();
    static int webCount = 0, dbCount = 0, cacheCount = 0, apiCount = 0;

    static class ServiceThread extends Thread {

        String serviceName;
        int sleepTime;

        ServiceThread(String name, int sleep) {
            serviceName = name;
            sleepTime = sleep;
        }

        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(sleepTime);
                } catch (Exception e) {}

                String log = "[" + System.currentTimeMillis() + "] "
                        + serviceName + " INFO Log Entry " + i + "\n";

                synchronized (logBuffer) {
                    logBuffer.append(log);
                }

                if (serviceName.equals("Web")) webCount++;
                if (serviceName.equals("Database")) dbCount++;
                if (serviceName.equals("Cache")) cacheCount++;
                if (serviceName.equals("API")) apiCount++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Thread web = new ServiceThread("Web", 100);
        Thread db = new ServiceThread("Database", 150);
        Thread cache = new ServiceThread("Cache", 80);
        Thread api = new ServiceThread("API", 120);

        web.start();
        db.start();
        cache.start();
        api.start();

        web.join();
        db.join();
        cache.join();
        api.join();

        System.out.println(logBuffer.toString());

        System.out.println("Web Logs: " + webCount);
        System.out.println("DB Logs: " + dbCount);
        System.out.println("Cache Logs: " + cacheCount);
        System.out.println("API Logs: " + apiCount);
        System.out.println("Total Characters: " + logBuffer.length());
    }
}
