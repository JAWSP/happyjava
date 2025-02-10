package Stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamEx04 {
    public static void main(String[] args) throws Exception{
        //디렉토리 안의 파일들 찾기
        Path path = Paths.get("src/main/java/Stream/");
        Stream<Path> stream = Files.list(path);
        stream.forEach(p-> System.out.println(p.getFileName()));
        stream.close();

        //파일 안의 내용 보기
        Stream<String> stream2 = Files.lines(Paths.get("src/main/java/Stream/StreamEx02.java"));
        stream2.forEach(System.out::println);
    }
}
