class Entry extends Thread {
    public void run() {
        System.out.println("Entry Monitoring Started");
    }
}

class QuestionPaper implements Runnable {
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Question Papers Distributed");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Attendance implements Runnable {
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Attendance Marked");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Collection implements Runnable {
    public void run() {
        try {
            Thread.sleep(15000);
            System.out.println("Answer Sheets Collected");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ExamHall {
    public static void main(String[] args) {
        Entry entry = new Entry();
        Thread qp = new Thread(new QuestionPaper());
        Thread att = new Thread(new Attendance());
        Thread col = new Thread(new Collection());

        entry.setPriority(5);
        qp.setPriority(10);
        att.setPriority(8);
        col.setPriority(7);

        System.out.println("QP State before start: " + qp.getState());

        entry.start();
        qp.start();
        att.start();
        col.start();

        System.out.println("QP State after start: " + qp.getState());
    }
}