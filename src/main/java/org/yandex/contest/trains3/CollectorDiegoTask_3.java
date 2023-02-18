package org.yandex.contest.trains3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorDiegoTask_3 {
    public static void main(String[] args) throws IOException {
        collectorDiego();
    }
    public static void collectorDiego() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if (n == 0) {
            System.out.println(0);
        } else {
            Set<String> set = Arrays.stream(bf.readLine().split(" ")).collect(Collectors.toSet());
            int[] sticks = set.stream().mapToInt(Integer::parseInt).toArray();
            Arrays.sort(sticks);
            int k = Integer.parseInt(bf.readLine());
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt)
                    .forEach(target -> stringBuilder.append(search(sticks, target)).append("\n"));
            System.out.println(stringBuilder);
        }
    }

    public static int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length -1;
        int m = 0;
        if (arr[l] >= target) {
            return 0;
        }
        if (arr[r] < target) {
            return r + 1;
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else {
                if (arr[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return arr[m] > target ? m : m + 1;
    }
}
