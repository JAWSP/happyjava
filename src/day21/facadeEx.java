package day21;

//퍼사드 패턴
//원타치 딸깍으로 여러개를 동시에

import day20.a.A;

class Projector {
    public void on() {
        System.out.println("켰다");
    }

    //대충 여러가지 기능들
    public void setIntput(String source) {
        System.out.println("대충 입력받은 내용임 ");
        System.out.println(source + " 옜다");
    }
}

class GoodStuff {
    public void on() {
        System.out.println("대충 좋은거");
    }
    public void off () {
        System.out.println("대충 좋은거 꺼짐");
    }
}

class AmuGoNa {
    public void on() {
        System.out.println("ddddddddddddd");
    }
    public void qwqwqw() {
        System.out.println("wqdqwjdwqdjkljsakldj");
    }
}


class Player {
    public void on() {
        System.out.println("끼얏호우");
    }
    public void play(String sth) {
        System.out.println("뭐? " + sth + " 를 하고싶다고?");
    }
}

//원바튼 필살 가능
class OneBotton {
    private Projector projector;
    private GoodStuff gs;
    private AmuGoNa amuGoNa;
    private Player p;

    public OneBotton(Projector projector, GoodStuff gs, AmuGoNa amuGoNa, Player p) {
        this.projector = projector;
        this.gs = gs;
        this.amuGoNa = amuGoNa;
        this.p = p;
    }

    public void ttalKkack(String subject) {
        System.out.println("딸깍");
        projector.on();
        projector.setIntput("머머머머");
        gs.on();
        amuGoNa.on();
        amuGoNa.qwqwqw();
        p.on();
        p.play("subject");
        System.out.println("이야~ 얼마나 편해~");
    }
    public void offAll() {
        System.out.println("끝낼래");
        gs.off();
        System.out.println("대충 다 끝남");
    }


}

public class facadeEx {
    public static void main(String[] args) {

        //저 위의 클라스들을 직접 다 사용하고 싶을 경우에
        //나는 저 위의 각종 클래스(무언가)를 다 하고 싶음
        //그럼 어떻게 할까?
        Projector p = new Projector();
        GoodStuff gs= new GoodStuff();
        AmuGoNa amuGoNa = new AmuGoNa();
        Player player = new Player();
        //다 초기화하고..

        p.on();
        p.setIntput("머머머머");
        gs.on();
        amuGoNa.on();
        amuGoNa.qwqwqw();
        player.on();
        player.play("그거");
        //이것저것 딸깍딸깍하고...

        //그걸 타파 하기 위한 원-버튼
        OneBotton oneBotton = new OneBotton(p, gs, amuGoNa, player);
        //모든걸 한번에
        oneBotton.ttalKkack("그거");
        //촥
        oneBotton.offAll();


    }
}
