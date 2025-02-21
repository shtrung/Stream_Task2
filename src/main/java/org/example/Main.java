package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );


        students
                .parallelStream()
                .flatMap(x -> x.grades()                                   //Сплющиваем Мапы объекта "Student"
                        .entrySet()
                        .stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey))            //Группируем по предмету
                .forEach((key, value) -> System.out.printf("%s - %f%n", key,  //Выводим в консоль
                        (double) value
                                .stream()
                                .mapToInt(Map.Entry::getValue)
                                .sum() / value.size()));                      //Находим среднеe арифметическое

    }
}
