package org.yandex.contest.trains3.hw1;

import java.util.Scanner;
import java.util.Stack;

public class StackTask_11 {
    public static void main(String[] args) {
        workWithStack();
    }

    static void workWithStack() {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] command = scanner.nextLine().split(" ");
            if (command.length == 2) {
                stack.push(Integer.valueOf(command[1]));
                System.out.println("ok");
            } else {
                switch (command[0]){
                    case "pop":
                        if (stack.empty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(stack.pop());
                        }
                        break;
                    case "back":
                        if (stack.empty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(stack.peek());
                        }
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "clear":
                        stack.clear();
                        System.out.println("ok");
                        break;
                    case "exit":
                        System.out.println("bye");
                        System.exit(0);
                }
            }
        }
    }
}
