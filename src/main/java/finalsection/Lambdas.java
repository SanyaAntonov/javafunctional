package finalsection;

import java.util.function.BiFunction;

public class Lambdas {

    public static void main(String[] args) {
        Integer number = null;
        int counter = 0;

        System.out.println(upperCaseName.apply("Alex", 20));
    }

    static BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
        if (name.isBlank()) {
            throw new IllegalStateException("");
        }
        System.out.println(age);
        return name.toUpperCase();
    };

}
