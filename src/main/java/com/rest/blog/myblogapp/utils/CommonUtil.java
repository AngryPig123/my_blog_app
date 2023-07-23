package com.rest.blog.myblogapp.utils;


import static com.rest.blog.myblogapp.utils.TextColor.RESET;

public class CommonUtil {

    public static String getFormat(TextColor textColor, String logFormat) {
        return textColor.getColor() + logFormat + RESET.getColor();
    }

}
