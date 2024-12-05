package day04;

public class TVUser {
    public static void main(String[] args) {
        TV tv = new TV();

        tv.TurnOff();
        tv.ChangeChannel(2);
        tv.TurnOn();
        tv.DownVolume();
        System.out.println(tv.channel);

        TV tv2 = new TV();
        tv2.brand = "LG";

        System.out.println(tv.brand +"\t"+ tv2.brand);

    }
}
