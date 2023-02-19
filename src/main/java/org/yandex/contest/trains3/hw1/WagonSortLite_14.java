package org.yandex.contest.trains3.hw1;

import java.util.Scanner;
import java.util.Stack;

public class WagonSortLite_14 {
    public static void main(String[] args) {
        String result =  wagonSort() ? "YES" : "NO";
        System.out.println(result);
    }
    static boolean wagonSort() {
        Stack<Integer> deadEndStack = new Stack<>();
        Stack<Integer> extraStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int wagonNumber = scanner.nextInt();
            while (!deadEndStack.empty() && deadEndStack.peek() < wagonNumber) {
                if (extraStack.empty() || extraStack.peek() < deadEndStack.peek()) {
                    extraStack.push(deadEndStack.pop());
                } else {
                    return false;
                }
            }
            deadEndStack.push(wagonNumber);
        }
        return extraStack.empty() || extraStack.peek() < deadEndStack.peek();
    }
}
