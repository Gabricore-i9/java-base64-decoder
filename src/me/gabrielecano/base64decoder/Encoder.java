package me.gabrielecano.base64decoder;

import java.util.Base64;

public class Encoder {
    public static String encode(String str) {
        return new String(Base64.getEncoder().encodeToString(str.getBytes()));
    }
}
