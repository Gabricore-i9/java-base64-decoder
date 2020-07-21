package base64decoder;

import java.io.IOException;

import static base64decoder.Controller.hashbase64decoded;

public class Opener {
    public static void OpenerMethod() throws IOException {
        Runtime rt = Runtime.getRuntime();
        String url = hashbase64decoded;
        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
}
