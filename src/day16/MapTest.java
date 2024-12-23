package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        //map는 key와 value를 가진다
        map.put(1, "kim");
        map.put(2, "na");
        map.put(3,"park");
        System.out.println(map);
        map.put(4, "lee");
        //map는 key는 중복이 안되지만, value는 중복이 된다
        map.put(5, "lee");
        System.out.println(map);

        //값에 접근하는 방식은 key쪽에 접근한다
        System.out.println(map.get(3));

        //키값을 보고 싶다면? keyset()
        Set<Integer> keys = map.keySet();

        Iterator<Integer> iter = keys.iterator();

        while(iter.hasNext()) {
            Integer key = iter.next();
            String item = map.get(key);
            System.out.println(key + " : " + item);
        }

        System.out.println("반복자 + for each");
        for (Integer k : keys) {
            System.out.println(k + " : " + map.get(k));
        }


    }
}
