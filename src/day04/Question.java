package day04;
class Student {
    private String name;
    private int age;
    private String grade;

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setGrade(String grade) {this.grade = grade;}

    public String getName() {return this.name; }
    public int getAge() {return this.age; }
    public String getGrade() {return this.grade; }
}

class  Television {
    boolean power;
    int channel;

    Television() {
        power = false;
        channel = 1;
    }


    void togglePower() {
        System.out.println("전원이 켜졌습니다");
        this.power = true;
    }

    void ChangeChannel(int newChannel) {
        if (power == false)
            System.out.println("TV키시오");
        else {
            this.channel = newChannel;
            System.out.println("채널을 " + this.channel+"번으로 변경했습니다");
        }
    }
}

class Animal {
    String name;
    String type;

    void setName(String name) {this.name = name;}
    void setType(String type) {this.type = type;}

    String getName() {return this.name;}
    String getType() {return this.type;}

    public Animal initAnimal(String name, String type) {
        Animal animal = new Animal();
        animal.name = name;
        animal.type = type;
        return animal;
    }

}

public class Question {

    int a;
    int b;
    public Question init(int c, int d)
    {
        Question q = new Question();
        q.a = c;
        q.b = d;
        return q;
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("asd");
        student.setAge(10);
        student.setGrade("2학년");

        System.out.println("name : " + student.getName() + "/age : " + student.getAge() + "/grade : " + student.getGrade());

        Television tv = new Television();

        tv.togglePower();
        tv.ChangeChannel(5);

        //계산기는 전에 만듦
        Calculator calculator = new Calculator();
        System.out.println("더하기 결과: " + calculator.plus(10, 5));
        System.out.println("빼기 결과: " + calculator.minus(10, 5));
        System.out.println("곱하기 결과: " + calculator.multiply(10, 5));
        System.out.println("나누기 결과: " + calculator.divide(10, 5));

        Animal poppy = new Animal();
        Animal navi = new Animal();
        Animal zzz = new Animal();

        poppy.setName("뽀삐"); poppy.setType("개");
        navi.setName("나비"); navi.setType("고양이");
        zzz.setName("찡찡이"); zzz.setType("햄스터");

        System.out.println("이름: " + poppy.getName() + ", 종류: " + poppy.getType());
        System.out.println("이름: " + navi.getName() + ", 종류: " +  navi.getType());
        System.out.println("이름: " + zzz.getName() + ", 종류: " + zzz.getType());

    }
}
