package day16;

import java.util.*;

public class PersonDemo {
    //Person객체로 map를 만들꺼면 키와 값을 각각 뭘로 할꺼니?

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Map<Integer, Person> personMap = new HashMap<>();
        Set<Person> personSet = new HashSet<>();

        Person person1 = new Person();
        Person person2 = new Person(2, "asd", "213", "?");
        Person person3 = new Person(3, "sdfdsf", "12345", "ssss");
        Person person4 = new Person(4, "hostar", "4444", "4444444");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);


        personMap.put(person1.getId(), person1);
        personMap.put(person2.getId(), person2);
        personMap.put(person3.getId(), person3);
        personMap.put(person4.getId(), person4);


        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);

        //특정 번호에 해당하는 객체를 찾고 싶다면?

        //list
        int id = 3;
        Person resultList;
        for (Person p : personList) {
            if (p != null && id == p.getId()) {
                resultList = p;
                System.out.println(resultList);
            }
        }
        //map
        Person reultMap;
        Set<Integer> idKeys = personMap.keySet();
        for (Integer k : idKeys) {
            if (k != null && id == k) {
                reultMap = personMap.get(k);
                System.out.println(reultMap);
            }

        }
        //set
        Person resultSet;
        String name = "asd";
        Iterator<Person> ite = personSet.iterator();
        while (ite.hasNext()) {
            //요거는 null가드
           Person tmp = ite.next();
            if (tmp != null && tmp.getName().equals(name)) {
                resultSet = tmp;
                System.out.println(resultSet);
            }
        }
        //왜안됨????

        //원하는 객체를 찾고 싶다면?
        //list

        Person finding = new Person(2, "asd", "@!", "SAdqw");

        for (Person p : personList) {
            if (p != null && finding.equals(p.getName()))
                System.out.println(p);
        }

        //set
        System.out.println(personSet.contains(finding.getName()));

        //map

    }
}
