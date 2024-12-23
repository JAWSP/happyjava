package day16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class PopulationManager {


    //알맞게 구현해 주세요.
    private Map<String, Integer> pm = new HashMap<>();

    public void addOrUpdateCity(String key, int value) {

    }

    public boolean removeCity(String target) {
        if (pm.get(target) == null)
                return false;
        return pm.remove(target, pm.get(target));
    }

    public void displayPopulation(String target) {
        if (pm.get(target) == null)
            return ;
        System.out.println(pm.get(target));
    }

    public void displayAll() {
        Set<String> ms = pm.keySet();
        for (String s : ms) {
            System.out.println(s + " :" + pm.get(s));
        }
    }

    public static void main(String[] args) {

        final int ADD_OR_UPDATE = 1;
        final int REMOVE = 2;
        final int DISPLAY =3;
        final int DISPLAY_ALL =4;
        final int EXIT = 5;

        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (1: 추가/수정, 2: 삭제, 3: 조회, 4: 전체 조회, 5: 종료): ");
            int command = scanner.nextInt(); // 사용자가 명령을 숫자로 입력
            if (command == EXIT) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case ADD_OR_UPDATE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case REMOVE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case DISPLAY:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case DISPLAY_ALL:
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();    }
}
