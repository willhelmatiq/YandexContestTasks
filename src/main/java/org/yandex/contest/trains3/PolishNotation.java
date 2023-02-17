package org.yandex.contest.trains3;

import java.util.Scanner;
import java.util.Stack;

public class PolishNotation {

    public static void main(String[] args) {
        calculate();
    }
    static void calculate() {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        for (int i = 0; i < items.length; i++) {
            if(items[i].length() == 1) {
                if (items[i].charAt(0) == '+') {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a + b));
                } else if (items[i].charAt(0) == '-') {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a - b));
                } else if (items[i].charAt(0) == '*') {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a * b));
                } else {
                    stack.push(items[i]);
                }
            } else {
                stack.push(items[i]);
            }
        }
        System.out.println(stack.pop());
    }
}
