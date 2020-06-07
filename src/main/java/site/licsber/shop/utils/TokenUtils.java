package site.licsber.shop.utils;

import java.util.UUID;

public class TokenUtils {

    public static String genToken() {
        return UUID.randomUUID().toString();
    }

}
