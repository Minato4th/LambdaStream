package com.endava;

import com.endava.models.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Gender.FEMALE;
import static com.endava.models.Gender.MALE;

public class Main {

    public static final List<User> USERS = Arrays.asList(new User("Vasea", MALE, 39),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40),
            new User("Igor", MALE, 55),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40));


    public static void main(String args[]) {

        //Count how many occurrences of each word are in the string
        Stream.of("Hello", "heloMotto")
                .map(String::length)
                .forEach(System.out::println);


        printDelimiterLine();

        //Write a method that will filter collection of users that are > 40 years
        USERS.stream()
                .filter(user -> user.getAge() > 40)
                .forEach(System.out::println);


        printDelimiterLine();


        //Write a method to extract the youngest user
        System.out.println(USERS.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList())
                .get(0)
        );


        USERS.stream()
                .min(Comparator.comparing(User::getAge))
                .ifPresent(System.out::println);


        printDelimiterLine();


        USERS.stream().map(User::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

        USERS.stream().map(User::getName)
                .distinct()
                .forEach(System.out::println);


        printDelimiterLine();

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        printDelimiterLine();

        USERS.stream()
                .parallel()
                .map(User::getName)
                .filter(string -> string.startsWith("A"))
                .forEach(System.out::println);

        printDelimiterLine();

        System.out.println(USERS
                .stream()
                .collect(Collectors.groupingBy(User::getGender)));
        printDelimiterLine();

        System.out.println(Stream.of(new User("Vasea", MALE, 39),
                new User("Sveta", FEMALE, 30),
                new User("Jenea", MALE, 40))
                .map(User::getName)
                .collect(Collectors.joining(" *** ")));

        printDelimiterLine();

        System.out.println(Stream.of(new User("Vasea", MALE, 39),
                new User("Sveta", FEMALE, 30),
                new User("Jenea", MALE, 40))
                .collect(Collectors.groupingBy(User::getGender, Collectors.counting())));

        printDelimiterLine();

        System.out.println(
                USERS.stream()
                        .filter(user -> user.getGender() == MALE)
                        .sorted(Comparator.comparing(User::getAge))
                        .collect(Collectors.toSet()));

        printDelimiterLine();

    }

    public static void printDelimiterLine() {
        System.out.println("\n-------------------------------------------------------\n");
    }
}
