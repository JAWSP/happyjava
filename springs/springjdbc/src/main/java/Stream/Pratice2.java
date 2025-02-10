package Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pratice2 {
    public static void main(String[] args) {
        //주어진 정수 배열에서 짝수만을 찾아 그 합을 구하시오.
        int[] numbers = {3, 10, 4, 17, 6};
        System.out.println(Arrays.stream(numbers)
                .filter(i -> i % 2 ==0)
                .sum());

        //주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 선택하여 대문자로 변환하고, 결과를 리스트로 반환하시오.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> res = words.stream()
                .filter(s -> s.length() >= 5)
                .map(s -> s.toUpperCase())
                .toList();
        System.out.println(res);

        @AllArgsConstructor
        @Getter

        class Student {
            public String name;
            public int score;
        }

        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        students.stream()
                .filter(s -> s.getScore() >= 80)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s ->System.out.println(s.getName()));

        @AllArgsConstructor
        @Getter
        class Employee{
            private String name;
            private String department;
            private double salary;
        };

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        employees.stream()
                .collect(Collectors.partitioningBy(Employee::getDepartment))
    }


}
