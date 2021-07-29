/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

/**
 *
 * @author lenovo pc
 */
public class UserLogin {
    private static String userId, username;
    
    public static String getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUserId(String userId) {
        UserLogin.userId = userId;
    }

    public static void setUsername(String username) {
        UserLogin.username = username;
    }
    
}
