import java.util.StringTokenizer;

public class ContactParser {

    public static void parseContacts(String input) {

        String[] contacts = input.split("\n");

        int contactCount = 0;

        for (String contactLine : contacts) {

            if (contactLine.trim().isEmpty())
                continue;

            StringTokenizer tokenizer = new StringTokenizer(contactLine, ";");

            String name = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String phone = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String email = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String address = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";

            displayContactCard(name, phone, email, address);

            contactCount++;
        }

        System.out.println("\nTotal Contacts Processed: " + contactCount);
    }

    public static void displayContactCard(String name, String phone,
                                          String email, String address) {

        System.out.println("======================================");
        System.out.println("Name    : " + (name.isEmpty() ? "N/A" : name));
        System.out.println("Phone   : " + (phone.isEmpty() ? "N/A" : phone));
        System.out.println("Email   : " + (email.isEmpty() ? "N/A" : email));
        System.out.println("Address : " + (address.isEmpty() ? "N/A" : address));
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        String input =
                "John Doe;+1-555-0101;john@email.com;123 Main St, NYC\n" +
                "Jane Smith;+1-555-0102;jane@email.com;456 Oak Ave, LA\n" +
                "Mike Brown;+1-555-0103;mike@email.com;789 Pine Rd, Chicago\n" +
                "Emily White;;emily@email.com;Miami Beach\n" +
                "Chris Green;+1-555-0105;;Houston";

        parseContacts(input);
    }
}
