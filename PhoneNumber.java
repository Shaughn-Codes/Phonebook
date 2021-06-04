import java.io.*;
import java.util.Scanner;

/**
 *
 * @author shaug
 */
public class PhoneNumber {

    public PhoneNumber(String number) {
        this.number = number;

    }

    public String toString() {

        return number;

    }

    public String getAreaCode() {
        return "" + number.charAt(1) + "" + number.charAt(2) + number.charAt(3);

    }

    public String getExchange() {

        return number.charAt(5) + "" + number.charAt(6) + "" + number.charAt(7);
    }

    public String getLineNumber() {
        return number.charAt(9) + "" + number.charAt(10) + "" + number.charAt(11) + "" + number.charAt(12);
    }

    public boolean equals(PhoneNumber other) {
        return number.equals(other.number);
    }

    public static PhoneNumber read(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        String number = scanner.next();
        return new PhoneNumber(number);
    }

    public boolean isTollFree() {
        boolean result = false;
        if (number.charAt(1) == '8') {
            result = true;

        }
        return result;
    }

    private String number;
}