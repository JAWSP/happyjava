package day04;
public class Calculator {
    Calculator() {
        System.out.println("안녕 난 계산기야");
    }
    int plus(int ... values)
    {
        int result = 0;
        for (int i : values)
            result += i;
        return result;
    }
    double plus(double ... values)
    {
        double result = 0;
        for (double i : values)
            result += i;
        return result;
    }
    int minus(int a, int b)  {return (a - b);}
    double minus(double a, double b)  { return (a - b);}
    int multiply(int a, int b) {return (a * b);}
    double multiply(double a, double b) {return (a * b);}
    int divide(int a, int b) {return (a / b);}
    double divide(double a, double b) {return (a / b);}
    int naMoJi(int a, int b) {return (a % b);}
    double naMoJi(double a, double b) {return (a % b);}


    int getRandomNum(int a) {
        return ((int)(Math.random() * a) + 1);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();

        System.out.println(cal.plus(10, 20, 30, 40, 50));
        System.out.println(cal.plus(10.1, 20.3, 30.6, 40, 50.1));
        System.out.println(cal.getRandomNum(cal.naMoJi(5, 3)));

    }

}
