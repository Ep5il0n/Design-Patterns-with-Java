import jdk.javadoc.internal.doclets.formats.html.resources.standard;

class DatabaseManager {
    private static DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("Singleton constructed");
    }

    public static DatabaseManager getInstance() {
        if(instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
}

public class singletonPattern {
    public static void main(String[] args) {
        DatabaseManager db = DatabaseManager.getInstance();
        System.out.println(db);
        DatabaseManager db2 = DatabaseManager.getInstance();
        System.out.println(db2);
    }
}
