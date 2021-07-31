package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional.ofNullable(null)
                .ifPresentOrElse(
                        value -> System.out.println("Sending hello to " + value),
                        () -> {
                            System.out.println("Not send hello");
                        });
    }
}
