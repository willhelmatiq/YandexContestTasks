package org.yandex.contest;

import java.util.Scanner;

/**
 *      see task description in the  src/main/resources/ZeroOneTask.pdf
 */

public class ZeroOne {

    public static void main(String[] args) {
        solveTask();
    }

    static void solveTask() {
        Scanner scanner = new Scanner(System.in);
        String firstStr = scanner.nextLine();
        String secondStr = scanner.nextLine();
        StringBuilder firstNumber = convertFromSymbolsToNumericChars(firstStr);
        StringBuilder secondNumber = convertFromSymbolsToNumericChars(secondStr);
        compareAndPrint(firstNumber, secondNumber);
    }
    static StringBuilder convertFromSymbolsToNumericChars(String strNumber) {
        StringBuilder resultStr = new StringBuilder();
        int i = 0;
        while (i < strNumber.length()) {
            if (strNumber.charAt(i) == 'o') {
                resultStr.append('1');
                i += 3;
            } else if (strNumber.charAt(i) == 'z') {
                resultStr.append('0');
                i += 4;
            }
        }
        return resultStr;
    }

    static void compareAndPrint(StringBuilder firstNumber, StringBuilder secondNumber) {
        int f = 0;
        int s = 0;
        while (f < firstNumber.length() && s < secondNumber.length()) {
            f = getPosOfOne(firstNumber, f);
            s = getPosOfOne(secondNumber, s);
            if (firstNumber.length() - f > secondNumber.length() - s) {
                System.out.println(">");
                return;
            } else if (firstNumber.length() - f < secondNumber.length() - s){
                System.out.println("<");
                return;
            } else {
                if (f >= firstNumber.length() - 1) {
                    System.out.println("=");
                    return;
                }
                f++;
                s++;
            }
        }
    }
    static int getPosOfOne(StringBuilder chars, int start) {
        for (int i = start; i < chars.length(); i++) {
            if (chars.charAt(i) == '1') {
                return i;
            }
        }
        return chars.length();
    }
}
