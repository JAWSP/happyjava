package day03;

public class ForEach {
    public static void main(String[] args) {
        int[] iarr = {1,2,3,4,5,6,7,8};

        //foreach for(변수:반복되는 자료구조)
        for (int num:iarr) {
            System.out.println(num);
        }

        String [] sarr = {"QWE", "qew", "E12", "2ewa"};

        for (String s:sarr) {
            System.out.println(s);
        }

        /*
                int[][]arr = {{0, 1, -1}, {2, 3, 4, -3, -2, -1}};
        a: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] < 0)
                    continue a;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
         */

        //array에 있던걸 돚거
        int[][]arr = {{0, 1, -1}, {2, 3, 4, -3, -2, -1}};
        a: for (int[] i :arr) {
            for (int j : i){
                if (j < 0)
                    continue a;
                System.out.print(j + "\t");
            }
            System.out.println();
        }

    }
}
