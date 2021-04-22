package me.gabrielecano.base64decoder;

import java.net.URL;

public class UrlValid {
    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
