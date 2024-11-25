
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ToolsUtil {
    
    public static void ShowErrorDialog(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}