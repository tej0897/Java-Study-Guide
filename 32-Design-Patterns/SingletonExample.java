/**
 * Day 32 - Design Patterns: Singleton
 */
public class SingletonExample {

    static class Database {
        private static Database instance;
        private String connectionString;

        private Database() {
            connectionString = "Connected";
        }

        static synchronized Database getInstance() {
            if (instance == null) {
                instance = new Database();
            }
            return instance;
        }

        void query(String sql) {
            System.out.println("Executing: " + sql);
        }
    }

    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println("Same instance: " + (db1 == db2));
        db1.query("SELECT * FROM users");
    }
}


