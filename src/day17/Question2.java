package day17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TextFileManager {
    private String path;

    TextFileManager(String filepath) {
        this.path = filepath;
    }
    public List<String> readFromFile() throws IOException {
        List<String> arr = new ArrayList<>();
        FileInputStream in = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String output;
        while ((output = br.readLine()) != null) {
            arr.add(output);
            System.out.println(output);
        }
        br.close();
        in.close();

        return arr;
    }

    public void writeToFile(List<String> userInput) throws IOException {
        PrintWriter pw = new PrintWriter(this.path);
        for (String s : userInput) {
            pw.println(s);
        }
        pw.close();
    }
    //파일 IO작업을 캡슐화, 파일 쓰기와 읽기
}

class UserInputHandler {

    public List<String> getUserInput() throws IOException {
        List result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            result.add(br.readLine());
        }
        br.close();

        return result;
    }
    //사용자 입력을 처리
}
public class Question2 {

    public static void main(String[] args) {
        String filePath = "texts.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();

        try {
            List<String> userInput = inputHandler.getUserInput();
            fileManager.writeToFile(userInput);

            List<String> fileContent = fileManager.readFromFile();
            System.out.println("Content of the file:");
            fileContent.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
