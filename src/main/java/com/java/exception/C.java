package com.java.exception;

import com.java.collection.A;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kunjie.zhang on 2018/5/11.
 */
public class C extends A {
    public static void main(String[] args) throws Exception {
        String line = "This order was placed for QT3000";
        String pattern = "(\\D*)(\\d+)(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group(0));

        }

    }
}
