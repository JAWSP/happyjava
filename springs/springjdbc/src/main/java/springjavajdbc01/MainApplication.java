package springjavajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//얘가 있어야지 실행됨
@SpringBootApplication
public class MainApplication  {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//    }
    //요 위에거 대용으로 쓰임
    //commandLineRunner객체를 등록
    //기존에는 직접 객체를 만들어서 등록을 했었는데
    //이젠 람다식으로 간단하게 등록이 가능하다
    //인자로 받는건 유저저장소에 대한 리포지터리
    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//
//            }
//        }; -> 얘랑 같음 저걸 람다식으로 줄인다는거
        return args -> {
            //만들기
            //userRepository.save(new User("asd", "qq@!"));

            //찾아보기, 리턴이 Oprional이라서 get()로 가져와야 한다
            User user = userRepository.findById(1L).get();
            System.out.println(user);
            //세어보기
            System.out.println(userRepository.count());

            //아니 선언만 해줘도 이게 되네
            userRepository.findByName("asd").stream().forEach(System.out::println);


        };
    }
}
