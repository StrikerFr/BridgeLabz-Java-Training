class Product {

    String title, sku, category, brand, model;
    double price, discount;

    Product(String t, String s, String c, String b, String m,
            double p, double d) {
        title = t; sku = s; category = c;
        brand = b; model = m; price = p; discount = d;
    }

    public String generateDescription() {

        StringBuilder sb = new StringBuilder();

        sb.append("<h1>").append(title).append("</h1>");
        sb.append("<p>SKU: ").append(new StringBuilder(sku).reverse()).append("</p>");

        sb.append("<h2>Basic Info</h2>");
        sb.append("<p>").append(category).append(" - ")
                .append(brand).append(" - ").append(model).append("</p>");

        sb.append("<h2>Features</h2><ul>");
        sb.append("<li>High Performance</li>");
        sb.append("<li>Durable Build</li>");
        sb.append("<li>Energy Efficient</li>");
        sb.append("<li>Premium Design</li></ul>");

        double finalPrice = price - (price * discount / 100);

        sb.append("<h2>Pricing</h2>");
        sb.append("<p>Original: ").append(price)
                .append(" | Discount: ").append(discount)
                .append("% | Final: ").append(finalPrice).append("</p>");

        sb.append("<p><b>Limited Time Offer!</b></p>");

        return sb.toString();
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {

        Product laptop = new Product("Gaming Laptop",
                "LAP12345", "Electronics", "Dell",
                "XPS", 1200, 10);

        String desc = laptop.generateDescription();

        System.out.println(desc);
        System.out.println("Description Length: " + desc.length());
    }
}
