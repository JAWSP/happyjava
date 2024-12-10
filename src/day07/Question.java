package day07;

public class Question {
    public static int sumOfDigits(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                result += Character.getNumericValue(str.charAt(i));
        }
        return result;
    }

    public static String replaceAllWords(String original, String target, String replacement) {
        String result;
        result = original.replace(target, replacement);

        return result;
    }

    public static boolean checkProductNumber(String productNumber) {
        if (productNumber.length() != 6)
            return false;
        if (!Character.isLetter(productNumber.charAt(0)) || !Character.isLetter(productNumber.charAt(1)))
            return false;
        for (int i = 2; i < 6; i++) {
            if (!Character.isDigit(productNumber.charAt(i)))
                return false;
        }
        return true;

    }

    public static int spaceCount(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++)
            if (Character.isWhitespace(str.charAt(i)))
                result++;

        return result;
    }

    public static String reverseChange(String str) {
        //객체 생성자에 문자열을 넣고
        StringBuilder builder = new StringBuilder(str);
        //reverse의 리턴형이 객체라 toString()로 출력
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits("a1b2c3d9"));
        System.out.println(replaceAllWords("I like cat. Cat is cute.", "cat", "dog"));
        System.out.println(checkProductNumber("te3456"));
        System.out.println(spaceCount("test tset ts ttt"));
        System.out.println(reverseChange("abc"));




    }
}
