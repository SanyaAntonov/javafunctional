package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", FEMALE),
                new Person("Inga", FEMALE)
        );

        System.out.println("// imperative approach");
        // imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("// declarative approach");
        // declarative approach

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
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
