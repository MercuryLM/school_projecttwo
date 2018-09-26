package com.wjmShop.utils;

public class StringUtil {

    public static final String encodeURI(String source) {
        try {
            byte[] data = source.getBytes("UTF-8");
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                if ((b <= 'z' && b >= 'a') || (b <= 'Z' && b >= 'A') || (b <= '9' && b >= '0')) {
                    sb.append(Character.toChars(b)[0]);
                } else {
                    sb.append(String.format("%%%02X", b));
                }
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

}
