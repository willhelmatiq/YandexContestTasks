package org.yandex.contest.trains3.warmUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoringLecture_10 {

    public static void main(String[] args) throws IOException {
        countVariants();
    }

    static void countVariants() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Map<Character, Long> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (map.containsKey(tempChar)) {
                map.put(tempChar, (i + 1L) * (s.length() - i) + map.get(tempChar));
            } else {
                map.put(tempChar, (i + 1L) * (s.length() - i));
            }

        }
        map.keySet().stream().sorted().forEach(key -> System.out.println(key + ": " + map.get(key)));
    }
}