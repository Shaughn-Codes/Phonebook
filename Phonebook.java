import java.io.*;
import java.util.Scanner;

public class Phonebook {


    public static void main(String[] args) throws Exception {


        try {
            final int CAP = 100;
            PhonebookEntry[] phonebookEntries = new PhonebookEntry[CAP];
            final String filename = "phonebook.txt";
            int numElts = readArray(phonebookEntries, filename);
            for (int i = 0; i < numElts; i++) {
                System.out.println(phonebookEntries[i]);
            }


            Scanner keyboard = new Scanner(System.in);
            int lookupscnt = 0, reversecnt = 0;
            String lookup = "l";
            String reverse = "r";
            String quit = "q";
            String userInput;


            System.out.print("lookup, reverse-lookup, quit(l/r/q)?");

            while (keyboard.hasNext()) {
                userInput = keyboard.next();
                if (userInput.equals(lookup)) {
                    System.out.print("last name? ");
                    String nameLast = keyboard.next();
                    System.out.print("first name? ");
                    String nameFirst = keyboard.next();
                    Name names = new Name(nameLast, nameFirst);
                    String number = lookup(phonebookEntries, numElts, names);

                    if (number.equals("")) {
                        System.out.println("not found");
                    } else

                        System.out.println(nameFirst + " " + nameLast + "'s phone number is " + number);
                    lookupscnt++;
                    System.out.print("lookup, reverse-lookup, quit(l/r/q)? ");

                }

                if (userInput.equals(reverse)) {

                    System.out.print("phone number(nnn-nnn-nnnn)? ");
                    String number = keyboard.next();
                    PhoneNumber pn = new PhoneNumber(number);
                    String name = reverse(phonebookEntries, numElts, pn);
                    if (name.equals(" ")) {
                        System.out.println("--Phone number not found");
                    } else
                        System.out.println(number + " belongs to " + name);
                    reversecnt++;
                    System.out.print("lookup, reverse-lookup, quit(l/r/q)? ");


                }


                if (userInput.equals(quit)) {
                    System.out.println("You quit the System!");
                    System.out.println(lookupscnt + " Lookups preformed");
                    System.out.println(reversecnt + " Reverse Lookups preformed");


                }


            }


        }
        catch(FileNotFoundException s){
            System.out.println("*** IOE Exception **** phonebook.text (No such file or directory) ");
        }

        catch (Exception s){
            System.out.println("*** Exception *** Phonebook capacity exceeded - increase size of underlying" +
                    "array");
        }

    }

    public static int readArray(PhonebookEntry[] phonebookEntries, String filename) throws Exception {


        Scanner sc = new Scanner(new File(filename));
        int size = 0;
        //size is used as an index to the array, and it keeps track of the
        //first empty loc in the array, which is in effect the number of elts in arr

        while (sc.hasNext()){
            if (size == phonebookEntries.length){


                throw new Exception("More than 100 names");
            }



            phonebookEntries[size] = PhonebookEntry.read(sc);



            size++;
        }
        sc.close();
        return size;
    }



    public static String lookup(PhonebookEntry[] phonebookEntry,int size, Name names){
            for (int i = 0; i < size; i++){

                if (phonebookEntry[i].name.equals(names))
                    return phonebookEntry[i].getPhoneNumber();
            }


        return "";
    }


    public static String reverse(PhonebookEntry[] phonebookEntry, int size, PhoneNumber pn){

        for (int i = 0; i < size; i++){

            if (phonebookEntry[i].phoneNumber.equals(pn)){
                return phonebookEntry[i].getName();
            }

        }





        return " ";
    }


}
