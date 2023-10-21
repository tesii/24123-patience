package com.auca.patience;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<String, String> users = new HashMap<>();

    static {
        // Add predefined user credentials
        users.put("tesipatience15@gmail.com", "password123");
        // Add more users if needed
    }

    public static boolean isValidUser(String email, String password) {
        String storedPassword = users.get(email);
        return storedPassword != null && storedPassword.equals(password);
    }

}
