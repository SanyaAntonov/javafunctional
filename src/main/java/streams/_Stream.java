package streams;


import java.util.List;
import java.util.function.*;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Inga", FEMALE),
                new Person("Bob", OTHER)
        );

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemales =
                people.stream()
                        .anyMatch(personPredicate);

        System.out.println(containsOnlyFemales);


        people.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        OTHER
    }
}
