package day04;

public class Arrs {
    public static void main(String[] args) {
        int i = 10;

        int j = i;
        i += 10;
        System.out.println("i ::" + i);
        System.out.println("j ::" + j);

        int[] arr= {10};
        int[] arr2 = arr;

        arr[0] += 10;
        System.out.println("arr ::" + arr[0]);
        System.out.println("arr1 ::" + arr2[0]);


    }
}
