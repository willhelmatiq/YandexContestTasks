package org.yandex.contest.trains3.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap_19 {
    static int[] heap = new int[100000];
    static int heapLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            processQuery(br.readLine(), heap, sb);
        }
        System.out.println(sb);
    }

    static void processQuery(String query, int[] heap, StringBuilder result) {
        String[] queryParams = query.split(" ");
        if (Integer.parseInt(queryParams[0]) == 0) {
            heap[heapLength] = Integer.parseInt(queryParams[1]);
            heapLength++;
            pushUp(heap, heapLength - 1);
        } else {
            result.append(extractMax(heap)).append("\n");
        }
    }

    static int extractMax(int[] arr) {
        int max = arr[0];
        arr[0] = arr[heapLength - 1];
        heapLength--;
        heapify(arr, 0);
        return max;
    }

    static void heapify(int[] arr, int i) {
        while (2 * i + 1 < heapLength) {
            int childInd = 2 * i + 1;
            if (2 * i + 2 < heapLength && arr[2 * i + 1] < arr[2 * i + 2]) {
                childInd = 2 * i + 2;
            }
            if (arr[i] >= arr[childInd]) {
                break;
            }
            int temp = arr[childInd];
            arr[childInd] = arr[i];
            arr[i] = temp;
            i = childInd;
        }
    }

    static void pushUp(int[] arr, int i) {
        while (i-1 >= 0) {
            int parentInd = (i - 1) / 2;
            if (arr[parentInd] >= arr[i]) {
                break;
            }
            int temp = arr[parentInd];
            arr[parentInd] = arr[i];
            arr[i] = temp;
            i = parentInd;
        }
    }

}
