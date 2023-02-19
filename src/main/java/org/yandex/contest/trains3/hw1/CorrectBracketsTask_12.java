package org.yandex.contest.trains3.hw1;

import java.util.Scanner;
import java.util.Stack;

public class CorrectBracketsTask_12 {

    public static void main(String[] args) {
        if (isBracketSequenceCorrect()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static boolean isBracketSequenceCorrect() {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        scanner.close();
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char element = brackets.charAt(i);
            if (bracketStack.empty()) {
                if (element == ')' || element == ']' || element == '}') {
                    return false;
                } else {
                    bracketStack.push(element);
                }
            } else {
                if ((element == ')' && bracketStack.peek() == '(') || (element == ']' && bracketStack.peek() == '[')
                        || (element == '}' && bracketStack.peek() == '{')) {
                    bracketStack.pop();
                } else {
                    bracketStack.push(element);
                }
            }
        }

        return bracketStack.empty();
    }
}
