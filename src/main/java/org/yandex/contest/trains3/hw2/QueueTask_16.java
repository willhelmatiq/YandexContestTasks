package org.yandex.contest.trains3.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTask_16 {

    public static void main(String[] args) throws IOException {
        workWithQueue();
    }

    static void workWithQueue() throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            String[] command = br.readLine().split(" ");
            if (command.length == 2) {
                queue.add(Integer.valueOf(command[1]));
                System.out.println("ok");
            } else {
                switch (command[0]){
                    case "pop":
                        if (queue.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(queue.poll());
                        }
                        break;
                    case "front":
                        if (queue.isEmpty()) {
                            System.out.println("error");
                        } else {
                            System.out.println(queue.peek());
                        }
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "clear":
                        queue.clear();
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
