package org.yandex.contest.trains3.warmUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulStringTask_2 {

    public static void main(String[] args) throws IOException {
        countBeauty();
    }

    static void countBeauty() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(s.length());
        int maxBeauty =0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < alphabet.length(); i++) {
            int beautyOfSymbol = getMaxBeautyOfSymbol(s, alphabet.charAt(i), k);
            if (beautyOfSymbol > maxBeauty) {
                maxBeauty = beautyOfSymbol;
            }
        }
        System.out.println(maxBeauty);
    }
    static int getMaxBeautyOfSymbol(String s, char target, int penaltyPoint) {
        int start = 0;
        int end = 0;
        int maxBeauty = 0;
        while (start < s.length()) {
            while ((end < s.length()) && (s.charAt(end) == target || penaltyPoint > 0)) {
                if (s.charAt(end) != target) {
                    penaltyPoint--;
                }
                end++;
            }
            if (end - start + penaltyPoint > maxBeauty) {
                maxBeauty = end - start + penaltyPoint;
            }
            if (s.charAt(start) != target) {
                penaltyPoint++;
            }
            start++;
        }
        return maxBeauty;
    }
}
