package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class EOFtest {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("copied"));
             PrintWriter writer = new PrintWriter(new FileWriter("asd"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
