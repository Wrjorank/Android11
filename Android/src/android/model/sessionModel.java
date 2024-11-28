package android.model;

public class sessionModel {
    private static int userID;
    private static String username;

    // Getter untuk user ID
    public static int getUserID() {
        return userID;
    }

    // Setter untuk user ID
    public static void setUserID(int id) {
        userID = id;
    }
    
    public static String getUsername() {
        return username;
    }

    // Setter untuk user ID
    public static void setUsername(String username1) {
        username = username1;
    }
}