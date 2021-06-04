import java.util.Scanner;

/**
 *
 * @author shaughnbulgar
 */
public class PhonebookEntry {

    public PhonebookEntry(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }


    public String getName() {
        return name.toString();
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    public String toString(){return name + ": " + phoneNumber;}

    public boolean equals(PhonebookEntry other) {

        return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
    }


    public static PhonebookEntry read(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        Name name = Name.read(scanner);
        PhoneNumber phoneNumber = PhoneNumber.read(scanner);

        return new PhonebookEntry(name, phoneNumber);
    }

    public boolean call() {
        boolean result = false;
        if (phoneNumber.isTollFree()) {
            result = true;
            System.out.print("Dialing (toll-free): ");
        }
        return result;
    }


    Name name;
    PhoneNumber phoneNumber;
}