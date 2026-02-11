import java.util.ArrayList;
import java.util.List;

class SQLQueryBuilder {

    private StringBuilder query;
    private List<String> selectColumns = new ArrayList<>();
    private List<String> joins = new ArrayList<>();
    private List<String> whereConditions = new ArrayList<>();
    private List<String> orderBy = new ArrayList<>();
    private String tableName;
    private int limit = -1;

    public SQLQueryBuilder(String tableName) {
        this.tableName = tableName;
        this.query = new StringBuilder();
    }

    public void addSelectColumn(String column) {
        selectColumns.add(column);
    }

    public void addJoin(String table, String condition) {
        joins.add("JOIN " + table + " ON " + condition);
    }

    public void addWhereCondition(String condition, String operator) {
        if (whereConditions.isEmpty())
            whereConditions.add(condition);
        else
            whereConditions.add(operator + " " + condition);
    }

    public void addOrderBy(String column, String direction) {
        orderBy.add(column + " " + direction);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String build() {

        query.append("SELECT ");

        for (int i = 0; i < selectColumns.size(); i++) {
            query.append(selectColumns.get(i));
            if (i < selectColumns.size() - 1)
                query.append(", ");
        }

        query.append("\nFROM ").append(tableName);

        for (String join : joins)
            query.append("\n").append(join);

        if (!whereConditions.isEmpty()) {
            query.append("\nWHERE ");
            for (int i = 0; i < whereConditions.size(); i++)
                query.append(whereConditions.get(i)).append(" ");
        }

        if (!orderBy.isEmpty()) {
            query.append("\nORDER BY ");
            for (int i = 0; i < orderBy.size(); i++) {
                query.append(orderBy.get(i));
                if (i < orderBy.size() - 1)
                    query.append(", ");
            }
        }

        if (limit > 0)
            query.append("\nLIMIT ").append(limit);

        return query.toString();
    }

    public int getQueryLength() {
        return query.length();
    }
}

public class SQLDemo {
    public static void main(String[] args) {

        SQLQueryBuilder builder = new SQLQueryBuilder("users");

        builder.addSelectColumn("users.id");
        builder.addSelectColumn("users.name");
        builder.addSelectColumn("users.email");
        builder.addSelectColumn("orders.amount");
        builder.addSelectColumn("orders.date");

        builder.addJoin("orders", "users.id = orders.user_id");

        builder.addWhereCondition("users.age > 18", "");
        builder.addWhereCondition("orders.amount > 100", "AND");
        builder.addWhereCondition("users.status = 'active'", "AND");

        builder.addOrderBy("users.name", "ASC");
        builder.addOrderBy("orders.date", "DESC");

        builder.setLimit(100);

        String finalQuery = builder.build();

        System.out.println(finalQuery);
        System.out.println("\nQuery Length: " + builder.getQueryLength());
    }
}
