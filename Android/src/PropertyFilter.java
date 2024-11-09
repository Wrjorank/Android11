import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilter {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        // Remove specific properties
        properties.remove("application.title");
        properties.remove("application.vendor");

        // Use the remaining properties
        System.out.println(properties);
    }
}
