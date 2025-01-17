package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

//컴퍼넌트 스캔, 이거 안하면 모든 패키지를 스캔해서 해줘야함
//그리고 컴포넌트라고만 붙인 데만 스캔해준다
//그 뿐만 아니라 다른 에노테이션이라 해도 해당 에노테이션에 컴포넌트가 붙여있음 찾는다
@ComponentScan(basePackages ="sample")
//빈을 등록
public class GameConfig {
//    //요걸 주석처리한 이유는 좀 많음
    @Bean
    public Dice dice() {
        return new Dice(20);
    }

//    @Bean
//    public Dice fdice() {
//        return new Dice();
//    }

////    @Bean
////    public Dice dndDice() {
////        return new Dice(20);
////    }


    //Dice를 이렇게 만들어도 됨
    @Bean
    public Player asd(Dice dice) {
       Player player = new Player(dice); //생성자 통해서 주입
       player.setName("asd");
       return player;
    }
    @Bean
    public Player bbb(Dice dice) {
        Player player = new Player();
        player.setDice(dice); //setter를 통한 주입
        player.setName("bbb");
        return player;
    }


    //이렇게도 됨
//    @Bean
//    public Player sven() {
//        return new Player(dice());
//    }

//    //이렇게 선언해도 알아서 다 넣어준다고 한다
//    @Bean Game game(List<Player> playerList) {
//        return new Game(playerList);
//    }

    //다시 새로 판짜기(컴포넌트 스캔한버전)
        @Bean Game game(List<Player> playerList) {
        Game game = new Game();
        game.setList(playerList);
        return game;
    }
}
