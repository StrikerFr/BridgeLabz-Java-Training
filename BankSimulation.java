class BankAccount {
    String holderName;
    String accountType;

    BankAccount(String name, String type) {
        this.holderName = name;
        this.accountType = type;
    }
}

class UserTask implements Runnable {
    BankAccount account;

    UserTask(BankAccount acc) {
        this.account = acc;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        for (int i = 1; i <= 3; i++) {
            System.out.println(t.getName() + " (" + account.accountType + 
                ") checking balance | Priority: " + t.getPriority());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Thread premium = new Thread(new UserTask(new BankAccount("Aman", "Premium")));
        Thread regular = new Thread(new UserTask(new BankAccount("Rahul", "Regular")));
        Thread basic = new Thread(new UserTask(new BankAccount("Ravi", "Basic")));

        premium.setPriority(10);
        regular.setPriority(5);
        basic.setPriority(1);

        premium.start();
        regular.start();
        basic.start();
    }
}