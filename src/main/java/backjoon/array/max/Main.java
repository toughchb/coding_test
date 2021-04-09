package backjoon.array.max;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = 0;
        int max_index = 1;
        for (int i = 0; i < arr.length; i++) {
            int input = sc.nextInt();
            if (input > max) {
                max = input;
                max_index = i + 1;
            }
            arr[i] = input;
        }
        System.out.println(max);
        System.out.println(max_index);

    }
}
