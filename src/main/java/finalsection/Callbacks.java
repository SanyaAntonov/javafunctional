package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        hello("John", null, value -> {
            System.out.println("No lastName provided for " + value);
        });

        hello2("John",
                null,
                () -> System.out.println("No lastName provided for "));
    }

    static void hello(String fistName, String lastName, Consumer<String> callback) {
        System.out.println(fistName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(fistName);
        }
    }

    static void hello2(String fistName, String lastName, Runnable callback) {
        System.out.println(fistName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }
}
