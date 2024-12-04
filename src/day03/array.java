package day03;

import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        int score[] = new int[5]; //선언 및 초기화
        //int[] score <- 이렇게 선언도 가능

        score[0] = 10;
        score[1] = 20;
        score[2] = 30;
        score[3] = 40;
        score[4] = 50;
        //score[5] = 60; -> 인덱스를 벗어나면 안됨

        for (int i = 0; i < 5; i++)
            System.out.print(score[i] + "\t");
        System.out.println();
        int sum = 0;
        for (int i = 0; i < score.length; i++)
            sum += score[i];
        int ave = sum / score.length;

        System.out.println("sum : " + sum + " average : " + ave);

        int[][] arrs = {{1, 2, 3}, {4}, {5, 100, 20000}};

        System.out.println(arrs[0][2] +" "+ arrs[1][0] );
        System.out.println("==========================");
        int[][]arr = {{0, 1, -1}, {2, 3, 4, -3, -2, -1}};
        a: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] < 0)
                    continue a;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
