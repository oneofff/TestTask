package ui.menu;

import domain.TelephoneNumber;
import ui.validation.EmailValidator;
import ui.validation.NumValidator;
import ui.validation.TelephoneNumberValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CreateMenu {
    public static String getName() {
        System.out.println("Enter name:");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static String getSurName() {
        System.out.println("Enter Surname:");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static String getEmail() {
        System.out.println("Enter email:");
        Scanner in = new Scanner(System.in);
        while (true) {
            String email = in.next();
            if (!EmailValidator.isValid(email)) {
                System.out.println("Error, please input valid email");
            } else {
                return email;
            }
        }
    }

    public static int choiceSuperRole() {
        System.out.println("Choice super role:");
        System.out.println("1.Super Admin");
        System.out.println("2.No super role");
        Scanner in = new Scanner(System.in);
        String choice;
        while (true) {
            choice = in.next();
            NumValidator numValidator = new NumValidator(choice, 1, 2);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                return numValidator.getNum();
            }
        }
    }

    public static int choiceFirstRole() {
        System.out.println("Choice first role:");
        System.out.println("1.User");
        System.out.println("2.Customer");
        Scanner in = new Scanner(System.in);
        String choice;
        while (true) {
            choice = in.next();
            NumValidator numValidator = new NumValidator(choice, 1, 2);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                return numValidator.getNum();
            }
        }
    }

    public static int choiceSecondRole() {
        System.out.println("Choice second role:");
        System.out.println("1.Admin");
        System.out.println("2.Provider");
        Scanner in = new Scanner(System.in);
        String choice;
        while (true) {
            choice = in.next();
            NumValidator numValidator = new NumValidator(choice, 1, 2);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                return numValidator.getNum();
            }
        }
    }

    public static ArrayList<TelephoneNumber> getTelephoneNumbers() {
        ArrayList<TelephoneNumber> telephoneNumbers = new ArrayList<TelephoneNumber>();
        telephoneNumbers.add(getTelephoneNumber());//123
        if (isOneMoreNumber()) {
            telephoneNumbers.add(getTelephoneNumber());
            if (isOneMoreNumber()) {
                telephoneNumbers.add(getTelephoneNumber());
            }
        }
        return telephoneNumbers;
    }

    private static boolean isOneMoreNumber() {
        System.out.println("One more telephone number?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        Scanner in = new Scanner(System.in);
        String choice;
        while (true) {
            choice = in.next();
            NumValidator numValidator = new NumValidator(choice, 1, 2);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                break;
            }
        }
        return choice.equals("1");
    }

    public static TelephoneNumber getTelephoneNumber() {
        while (true) {
            System.out.println("Enter telephone number:");
            Scanner in = new Scanner(System.in);
            String telNumber = in.next();
            if (!TelephoneNumberValidator.isValid(telNumber)) {

                System.out.println("Error, please input valid phone number");
            } else {
                return new TelephoneNumber(telNumber);
            }
        }
    }
}
