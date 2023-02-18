package org.yandex.contest.trains3;

import java.util.Arrays;
import java.util.Scanner;

public class BarChartTask_1 {
    public static void main(String[] args) {
        barChart();
    }

    public static void barChart() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int[] stash = new int[256];
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next());
        }
        stringBuilder.chars().forEach(value -> stash[value] = stash[value] + 1);
        int max = Arrays.stream(stash).max().getAsInt();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < stash.length; j++) {
                if (stash[j] > 0) {
                    if (max - stash[j] - i <= 0) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        for (int j = 0; j < stash.length; j++) {
            if (stash[j] > 0) {
                System.out.print((char) j);
            }
        }
    }
}
