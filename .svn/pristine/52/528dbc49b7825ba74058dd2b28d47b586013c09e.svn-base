package com.wjmShop.utils;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class CookieUtil {

    public static boolean hasCookie(String name, String value) {
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue().equals(value);
            }
        }
        return false;
    }
}
