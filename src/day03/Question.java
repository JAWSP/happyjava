package day03;

import java.util.Arrays;

public class Question {
    //역순
    public static void q1()
    {
        int[] numbers = {3, 6, 9, 12, 15};
        int answers[] = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
        {
            answers[i] = numbers[numbers.length - i - 1];
        }
        for (int i : answers)
            System.out.print(i + "\t");
        System.out.println();


    }
    //최대, 최소
    public static void q2()
    {
        double[] doubles = {1.5, 3.7, 2.4, 9.8, 7.6, 3.4};
        Arrays.sort(doubles);
        System.out.println("max : " + doubles[doubles.length - 1] + " min : " + doubles[0]);
    }
    //평균과 합계
    public static void q3()
    {
        int[] scores = {70, 85, 90, 45, 100};
        int sum = 0;
        for (int i : scores)
            sum += i;
        System.out.println("합 : " + sum + " 평균 : " + sum / scores.length);


    }
    //배열 이동
    public static void q4()
    {
        String[] words = {"Java", "Python", "C", "JavaScript"};
        String[] answer = new String[words.length];

        answer[0] = words[words.length - 1];
        for (int i = 1; i < words.length; i++)
            answer[i] = words[i - 1];
        for (String s: answer)
            System.out.print(s + "\t");
        System.out.println();
    }

    //합집합
    public static void q5()
    {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {0, 2, 4, 6, 8, 10, 3, 5};
        int[] answer = new int[5];
        int a = 0;

        //숫자 구하고
       r: for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    answer[a] = array1[i];
                    a++;
                    continue r;
                }
            }
        }
        for(int i = 0; i < a; i++)
            System.out.print(answer[i] + "\t");
        System.out.println();
    }
    //대각선 합 (0,0) (2 0) (1 1) (2 0) (2 2)
    public static void q6() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int answer = 0;
        int i = 0;
        int max = matrix.length - 1;

        while (max >= 0)
        {
            answer += matrix[i][i];
            answer += matrix[i][max];
            i++;
            max--;
        }
        if (matrix.length % 2 != 0)
            answer -= matrix[matrix.length/2][matrix.length/2];
        System.out.println(answer);

    }

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();

    }
}
