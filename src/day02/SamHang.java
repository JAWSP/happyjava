package day02;

public class SamHang {
    public static String  t()
    {
        System.out.println("양수임");
        return "양수";
    }

    public static String f() {
        System.out.println("음수임");
        return "음수";
    }
    public static void main(String[] args) {
        String pepe = "⣿⣿⣿⣿⣿⣿⣿⡿⠛⠉⠉⠉⠉⠛⠻⣿⣿⠿⠛⠛⠙⠛⠻⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⢀⣀⣀⡀⠀⠈⢄⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⠏⠀⠀⠀⠔⠉⠁⠀⠀⠈⠉⠓⢼⡤⠔⠒⠀⠐⠒⠢⠌⠿⢿⣿⣿⣿\n" +
                "⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⢀⠤⣒⠶⠤⠭⠭⢝⡢⣄⢤⣄⣒⡶⠶⣶⣢⡝⢿⣿\n" +
                "⡿⠋⠁⠀⠀⠀⠀⣀⠲⠮⢕⣽⠖⢩⠉⠙⣷⣶⣮⡍⢉⣴⠆⣭⢉⠑⣶⣮⣅⢻\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠉⠒⠒⠻⣿⣄⠤⠘⢃⣿⣿⡿⠫⣿⣿⣄⠤⠘⢃⣿⣿⠿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠤⠭⣥⣀⣉⡩⡥⠴⠃⠀⠈⠉⠁⠈⠉⠁⣴⣾⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠔⠊⠀⠀⠀⠓⠲⡤⠤⠖⠐⢿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⣿⡻⢷⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠠⡀⠀⠙⢿⣷⣽⣽⣛⣟⣻⠷⠶⢶⣦⣤⣤⣤⣤⣶⠾⠟⣯⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠉⠂⠀⠀⠀⠈⠉⠙⠛⠻⠿⠿⠿⠿⠶⠶⠶⠶⠾⣿⣟⣿⣿⣿\n" +
                "⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣶⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣟⢿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
        int num = 2;
        //삼항 연산자 (조건)? 참일때 : 거짓 일때;
        boolean b = (1 > num) ? true : false;

        String result = (num > 0) ? "양수" : "음수";
        String r = (num > 0) ? t() : f();

        System.out.println(result);

        if (num % 2 == 0)
            System.out.println(pepe);
        int a = 10;
        int value;
        if (a < 5)
            value = 20;
        else if (a > 10)
            value = 25;
        else
            value = 30;
        System.out.println(value);

        String spices = "cow";
        switch (spices) {
            case "frog":
                System.out.println(pepe);
                break;

            case "cow":
                System.out.println("그 정도면\n" +
                        "개혜잔데?⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠈⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡸⢤⣡⣴⣶⣾⣿⣿⣷⣾⣥⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⡙⠚⠀⠀⠀⠀⢀⣀⡀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣠⣴⣶⣶⣶⣦⠀⠀\n" +
                        "⠀⠀⠀⠠⣌⡁⠀⠀⢠⣾⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\n" +
                        "⠀⠀⠀⢐⡂⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠃⠀⠀\n" +
                        "⠀⠀⠠⢄⠈⠉⠀⠀⠀⠀⠉⠛⠋⢡⣿⡿⠛⠻⣿⣿⣿⡟⠛⠻⣿⣿⣿⡷⣄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠐⠒⠒⠀⠀⠀⠀⣀⣤⡖⠭⢹⣿⠁⠰⢂⣿⣿⣿⠀⠟⠀⣼⣿⣿⠒⠤⣉⢒⣤⡀⠀⠀\n" +
                        "⠀⠀⠠⠦⠀⠀⢀⣴⣿⣿⣿⡟⠊⣿⣿⣦⣴⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣶⣶⣾⣿⣿⣿⣦⠀\n" +
                        "⠀⠀⠉⣀⠀⢰⣿⣿⣿⣿⣿⠀⢠⡿⠛⠛⠛⠛⠻⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀\n" +
                        "⠀⠀⢐⠦⡀⠀⠻⣿⣿⣿⣿⣶⡞⠁⠀⣴⠀⠀⠀⣰⠂⠀⠙⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀\n" +
                        "⠀⠀⠔⣪⠕⠀⠀⠙⣿⣿⣿⣿⣄⡀⠀⠀⠀⠀⠀⠈⠀⠀⠀⣹⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠈⢀⢔⠅⠀⠀⠘⣿⣿⣿⣿⣿⣿⣶⣶⣦⣤⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠁⣡⢖⠄⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠡⠃⠂⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠃⠀⠀⠀⠀⠀⠀⠀\n");
                break;
            case "s": //그냥 이렇게도 가능
            case "ww":
            default:
                System.out.println("없");
        }
                int score = 90;
                String Str = "";
                switch (score){
                    case 100 :
                    case 99 :
                    case 98 :
                    case 97 :
                    case 96 :
                    case 95 :
                        Str = "A";
                        break;
                    case 94 :
                    case 93 :
                    case 92 :
                    case 91 :
                    case 90 :
                        Str = "B";
                        break;
                    case 89 :
                    case 88 :
                    case 87 :
                    case 86 :
                    case 85 :
                        Str = "C";
                        break;
                    case 84 :
                    case 83 :
                    case 82 :
                    case 81 :
                    case 80 :
                        Str = "D";
                        break;
                    default:
                        Str = "F";
                }
                System.out.println("학점은 "+Str+" 이고, 원점수는 "+score+" 입니다.");


        }


    }

