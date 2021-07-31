package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.isAdult;
import static combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alic",
                "alice@gmail.com",
                "+05125",
                LocalDate.of(2000, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid  We can store Customer in DB

        // Using combinator pattern

        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
