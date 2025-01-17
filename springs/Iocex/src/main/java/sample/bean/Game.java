package sample.bean;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Game {
    //플레이어 리스트도 공장을 통해서 생성,주입받을거임
    private List<Player> list;
    public Game() {
        System.out.println("아임 뉴 게이");
    }
    public Game(List<Player> list) {
        System.out.println("Game 생성");
        this.list = list;
    }

    public void play() {
        for (Player player: list) {
            player.play();
        }
    }

    public List<Player> getList() {
        return list;
    }

    public void setList(List<Player> list) {
        System.out.println(list.size());
        System.out.println(list.get(1).getName());
        this.list = list;
    }
}
