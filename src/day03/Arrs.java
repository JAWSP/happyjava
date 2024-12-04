package day03;

import java.util.Arrays;

public class Arrs {
    public static void main(String[] args) {
        int[] copyForm = {1, 2, 3};

        /*
        //만약에 배열을 복사하고 싶다면
        int[] copyTo = new int[copyForm.length];
        //기존은 이렇게 되는데
        for (int i = 0; i < copyForm.length; i++)
            copyTo[i] = copyForm[i];
         */
        //Young 하고 MZ한 Arrays를 쓰게 되면 된다
        //copyof(복사할 배열, 복사할 크기)
        //그러니까 strcpy와 같은거라고 생각혀면 된다 이말이야
        int[] copyTo = Arrays.copyOf(copyForm, copyForm.length);

        for (int i : copyTo)
            System.out.println(i);
    }
}
