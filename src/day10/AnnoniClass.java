package day10;

abstract class Cup {
    abstract void drink();
}

interface InstantClass {
    void instant();
}

public class AnnoniClass {
    public static void main(String[] args) {
        Cup cup = new Cup() {
            @Override
            void drink() {

            }
        };

        InstantClass is = new InstantClass() {
            @Override
            public void instant() {
                System.out.println("ㅎㅇ");
            }
        };

        InstantClass iss = new InstantClass() {
            @Override
            public void instant() {
                System.out.println("ㅎㅇㅎㅇ");
            }
        };

        is.instant();
        iss.instant();
    }
}
