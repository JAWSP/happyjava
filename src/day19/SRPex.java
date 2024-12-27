package day19;

import java.io.FileWriter;

/*
SRP 한 메서드엔 한가지 기능만
 */


class FileManager {
    public void writeSth(String name, String what) {
        try(FileWriter fw = new FileWriter(name)) {
            fw.write(what);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Person {
    private String name;

    public Person(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    //유저 정보 출력..? 얜 너무 투머치
    /*
    public void printName() {
        System.out.println(this.name);
    }
     */

    //파일에 유저정보 저장
    //여기서 기능 분리가 가능할텐데...
    public void saveUserToFile() {
        try(FileWriter w = new FileWriter("texts.txt")) {
            w.write("대충 유저 정보 입니다 " + name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class SRPex {
    public static void main(String[] args) {
        Person p = new Person("sad");
        FileManager fs = new FileManager();


        System.out.println(p.getName());
        fs.writeSth("texts.txt","대충 유저 정보 입니다 " + p.getName() );
       // p.saveUserToFile();
    }
}
