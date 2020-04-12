package com.finra.test.configuration;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConfiguration {
    public static Map<Character, String> keys = new HashMap<>();

    static {
        keys.put('0', "0");
        keys.put('1', "1");
        keys.put('2', "2abc");
        keys.put('3', "3def");
        keys.put('4', "4ghi");
        keys.put('5', "5jkl");
        keys.put('6', "6mno");
        keys.put('7', "7pqrs");
        keys.put('8', "8tuv");
        keys.put('9', "9wxyz");
    }
}
