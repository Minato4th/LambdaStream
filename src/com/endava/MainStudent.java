package com.endava;

import com.endava.models.Major;
import com.endava.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Major.BA;
import static com.endava.models.Major.EG;
import static com.endava.models.Major.MKL;
import static com.endava.Main.printDelimiterLine;

/**
 * Created by aborisco on 3/30/2018.
 */
public class MainStudent {

    public static final List<Student> STUDENT = Arrays.asList(new Student("Valera", 8.3, BA),
            new Student("Valera", 9.5, BA),
            new Student("Tom", 9.98, BA),
            new Student("Valera", 7.5, BA),
            new Student("Valera", 8.93, MKL),
            new Student("Valera", 7.32, MKL),
            new Student("Jim", 9.32, MKL),
            new Student("Valera", 8.3, MKL),
            new Student("Valera", 6.78, EG),
            new Student("Valera", 9.21, EG),
            new Student("Kate", 9.41, EG),
            new Student("Valera", 8.97, EG));


    public static void main(String[] args) {


        STUDENT.stream()
                .filter(student -> student.getName().equals("Valera"))
                .collect(
                        Collectors.groupingBy(Student::getMajor,
                                Collectors.maxBy(Comparator.comparing(Student::getScore))))
                .forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));



        printDelimiterLine();





        List<Student> students = new ArrayList<>();

        STUDENT.stream()
                .filter(student -> student.getName().equals("Valera"))
                .collect(Collectors.groupingBy(Student::getMajor))
                .forEach((major, st) ->
                        students.add(st.stream()
                                .max(Comparator.comparing(Student::getScore)).get())
                );
        students.forEach(System.out::println);




        printDelimiterLine();




        STUDENT.stream()
                .filter(student -> student.getName().equals("Valera"))
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.groupingBy(Student::getMajor))
                .forEach((major, st) ->
                        System.out.println(st.stream().findFirst())
                );



        printDelimiterLine();



        Stream.of(new Student())
                .flatMap(student -> {
                            List<Student> studentsList = new ArrayList<>();
                            Student bufSt = new Student();
                            double max = 0;

                            for (Major major : Major.values()) {

                                for (Student st : STUDENT) {
                                    if (st.getMajor().equals(major) && st.getName().equals("Valera") && st.getScore() > max){
                                        bufSt = st;
                                        max = st.getScore();
                                    }
                                }
                                studentsList.add(bufSt);
                                max = 0;

                            }

                            return Stream.of(studentsList);
                        }
                )
                .forEach(System.out::println);


        printDelimiterLine();


    }
}
