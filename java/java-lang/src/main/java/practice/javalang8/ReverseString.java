package practice.javalang8;

import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        String[] s = {"RamSharma", "WhatAFix", "Don'tThinkItIsCool", "CorrectMeIfIamWrong"};
        Stream.of(s).map(ReverseString::reverse).forEach(System.out::println);
    }

    private static String reverse(String s) {
        if (s.length() == 0)
            return "";
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
