package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07994649369"));
        System.out.println(isPhoneNumberValid("0799464969"));
        System.out.println(isPhoneNumberValid("89994649369"));

        System.out.println();

        System.out.println(isPhoneNumberValidPredicate.test("07994649369"));
        System.out.println(isPhoneNumberValidPredicate.test("0799464939"));
        System.out.println(isPhoneNumberValidPredicate.test("08994649369"));

        System.out.println();

        System.out.println("is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(isPhoneNumberContains3Predicate).test("07994649369"));
        System.out.println("is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.or(isPhoneNumberContains3Predicate).test("08994649369"));

        System.out.println("is phone number valid and contains number 3 = " +
                isPhoneNumberValidAndContains3BiPredicate.test("07994649369", "07994649369"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> isPhoneNumberContains3Predicate =
            phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> isPhoneNumberValidAndContains3BiPredicate =
            (phoneNumber, phone) -> phoneNumber.startsWith("07") && phoneNumber.length() == 11 && phone.contains("3");
}
