package org.yandex.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *      see task description in the  src/main/resources/regional_olympiad_2022.pdf task1
 */

public class VerbalCalc {
    static long currentSum;
    static int currentPosStart;

    public static void main(String[] args) throws IOException {
        solveTask();
    }

    static void solveTask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readInt(br);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt(br);
            currentSum += arr[i];
        }
        int k = readInt(br);
        for (int i = 0; i < k; i++) {
            int q = readInt(br);
            if (q == 1) {
                int pos = readInt(br);
                int element = readInt(br);
                int absPos = (pos + currentPosStart - 1) % n;
                currentSum -= arr[absPos];
                currentSum += element;
                arr[absPos] = element;
                System.out.println(currentSum);
            } else if (q == 2) {
                currentPosStart = ((currentPosStart - readInt(br)) % n + n) % n;
                System.out.println(currentSum);
            }
        }
        br.close();
    }

    /**
     *      метод написан, чтобы пройти ограничения по времени выполнения в тестирующей системе contest.yandex.ru
     */
    static int readInt(BufferedReader br) throws IOException {
        int number = 0;
        int charValue = br.read();
        boolean isPositive = true;
        while (charValue != 10 && charValue != 32) {    //читаем символы пока не встретим пробел либо перенос строки
            if (charValue == 45) {                      //обрабатываем отрицательные числа
                isPositive = false;
                charValue = br.read();
                continue;
            }
            number = number * 10 + Character.getNumericValue((char) charValue) ;
            charValue = br.read();
        }
        if (!isPositive) {
            number = number * -1;
        }
        return number;
    }
}

//    static void swapElement(long[] arr, int pos, long element) {
//        arr[pos] = element;
//    }
//
//    static void rotateArr(int l, int pos) {
//        int n = pos % l;
//        currentPosStart = ((currentPosStart - n) % l + l) % l;
//        if (currentPosStart - n < 0) {
//            currentPosStart =  currentPosStart - n + l;
//        } else {
//            currentPosStart = currentPosStart - n;
//        }
//    }

//    static long[] rotateArr(long[] arr, int rotations) {
//        int n = rotations % arr.length;
//        if (n != 0) {
//            int k = 0;
//            int d = arr.length/gcd(arr.length, n);
//            int posFrom = 0;
//            int posTo;
//            long tempFrom = arr[posFrom];
//            long tempTo;
//            while ( k < arr.length) {
//                if (posFrom + n < arr.length) {
//                    posTo = posFrom + n;
//                } else {
//                    posTo = (posFrom + n) - arr.length;
//                }
//                tempTo = arr[posTo];
//                arr[posTo] = tempFrom;
//                k++;
//                if (k % d == 0) {
//                    posFrom = posTo + 1;
//                    tempFrom = arr[posFrom];
//                } else {
//                    posFrom = posTo;
//                    tempFrom = tempTo;
//                }
//            }
//        }
//        return arr;
//    }
//
//    static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        }
//        return gcd(b, a % b);
//    }
//}
