import java.util.*;

public class ChatApplication {

    // Thread-safe conversation buffer
    static StringBuffer conversation = new StringBuffer();

    static List<String> allMessages = Collections.synchronizedList(new ArrayList<>());
    static Map<String, Integer> mentionCount = new HashMap<>();
    static Map<String, Integer> hashtagCount = new HashMap<>();

    static long startTime;
    static long endTime;

    // ==========================
    // Message Parsing
    // ==========================
    public static void parseMessage(String message) {

        StringTokenizer tokenizer = new StringTokenizer(message, " ");

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            if (token.startsWith("@")) {
                mentionCount.put(token,
                        mentionCount.getOrDefault(token, 0) + 1);
            }

            if (token.startsWith("#")) {
                hashtagCount.put(token,
                        hashtagCount.getOrDefault(token, 0) + 1);
            }
        }
    }

    // ==========================
    // Message Formatting
    // ==========================
    public static String formatMessage(String user, String message) {

        StringBuilder formatted = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(message, " ");

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            if (token.startsWith("@"))
                formatted.append("**").append(token).append("** ");
            else if (token.startsWith("#"))
                formatted.append("*").append(token).append("* ");
            else if (token.startsWith("/"))
                formatted.append("[CMD: ").append(token.substring(1)).append("] ");
            else
                formatted.append(token).append(" ");
        }

        String finalMessage = "[" + new Date() + "] "
                + user + ": " + formatted.toString().trim();

        return finalMessage;
    }

    // ==========================
    // User Thread
    // ==========================
    static class UserThread extends Thread {

        String username;
        String[] messages;

        UserThread(String name, String[] msgs) {
            username = name;
            messages = msgs;
        }

        public void run() {

            for (String msg : messages) {

                parseMessage(msg);

                String formatted = formatMessage(username, msg);

                synchronized (conversation) {
                    conversation.append(formatted).append("\n");
                }

                allMessages.add(msg);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        }
    }

    // ==========================
    // Analytics
    // ==========================
    public static void showAnalytics() {

        System.out.println("\n===== ANALYTICS REPORT =====");

        System.out.println("Total Messages: " + allMessages.size());

        // Most mentioned user
        String topMention = null;
        int maxMention = 0;

        for (String key : mentionCount.keySet()) {
            if (mentionCount.get(key) > maxMention) {
                maxMention = mentionCount.get(key);
                topMention = key;
            }
        }

        System.out.println("Most Mentioned: " + topMention);

        // Most used hashtag
        String topHashtag = null;
        int maxHashtag = 0;

        for (String key : hashtagCount.keySet()) {
            if (hashtagCount.get(key) > maxHashtag) {
                maxHashtag = hashtagCount.get(key);
                topHashtag = key;
            }
        }

        System.out.println("Most Used Hashtag: " + topHashtag);

        // Average length
        int totalLength = 0;
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;

        for (String msg : allMessages) {
            int len = msg.length();
            totalLength += len;
            maxLen = Math.max(maxLen, len);
            minLen = Math.min(minLen, len);
        }

        System.out.println("Average Length: "
                + (totalLength / allMessages.size()));
        System.out.println("Longest Message Length: " + maxLen);
        System.out.println("Shortest Message Length: " + minLen);

        System.out.println("Conversation Duration (ms): "
                + (endTime - startTime));
    }

    // ==========================
    // MAIN
    // ==========================
    public static void main(String[] args) throws Exception {

        startTime = System.currentTimeMillis();

        String[] aliceMsgs = {
                "Hey @Bob check #Java",
                "Learning #SpringBoot today",
                "/help needed for #Java",
                "Thanks @Charlie",
                "Good night #Programming"
        };

        String[] bobMsgs = {
                "Hi @Alice",
                "Using #Java and #SpringBoot",
                "Great job @Alice",
                "Check this out #Programming",
                "/logout"
        };

        String[] charlieMsgs = {
                "Hello everyone",
                "@Bob nice idea",
                "Let's code #Java",
                "I love #Programming",
                "@Alice see you"
        };

        Thread t1 = new UserThread("Alice", aliceMsgs);
        Thread t2 = new UserThread("Bob", bobMsgs);
        Thread t3 = new UserThread("Charlie", charlieMsgs);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        endTime = System.currentTimeMillis();

        System.out.println("===== CONVERSATION =====");
        System.out.println(conversation.toString());

        showAnalytics();
    }
}
