package day17;

import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            if (!file.exists()) {
                //파일생성은 예외처리가 필요함
                file.createNewFile();
                System.out.println("파일 만들어짐" + file.getAbsoluteFile());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        //그 파일이 실존하냐?
        System.out.println(file.exists());
        //절대 경로
        System.out.println(file.getAbsoluteFile());
        //파일 크기
        System.out.println(file.length());
        //쓰기 가능?
        System.out.println(file.canWrite());
        //읽기 가능?
        System.out.println(file.canRead());

        //현재 경로 보기
        System.out.println(System.getProperty("user.dir"));
        //현재 디렉터리를 나타내는 파일객체
        File dir = new File(".");
        //그 파일이 디렉토리냐
        System.out.println(dir.isDirectory());
        //얜 파일이 아니니 false라고 나옴
        System.out.println(dir.isFile());
        //디렉토리 안의 얘들을 볼 수 있음
        //근데 순서가 뒤죽박죽인 것 같아보이는데..
        String[] files = dir.list();
        for (String f: files) {
            System.out.println(f);
        }


    }
}
