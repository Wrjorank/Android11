package android.model;

public class sessionModel {
    private static int userID;

    // Getter untuk user ID
    public static int getUserID() {
        return userID;
    }

    // Setter untuk user ID
    public static void setUserID(int id) {
        userID = id;
    }
}