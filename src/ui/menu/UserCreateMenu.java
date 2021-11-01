package ui.menu;

import domain.roles.RoleFirstLevel;
import domain.roles.RoleSecondLevel;
import domain.roles.RoleSuper;
import service.validation.EmailValidator;
import service.validation.TelephoneNumberValidator;
import service.validation.NumValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserCreateMenu {

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

    private static String choiceSuperRole() {
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
                return numValidator.getNum() == 1 ? "SUPER_ADMIN" : "NOT_SELECTED";
            }
        }
    }

    private static String choiceFirstRole() {

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
                return (numValidator.getNum() == 1 ? "USER" : "CUSTOMER");
            }
        }
    }

    private static String choiceSecondRole() {
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
                return numValidator.getNum() == 1 ? "ADMIN" : "PROVIDER";
            }
        }
    }

    public static List<String> getRoles() {
        String[] roles = new String[3];
        roles[2] = choiceSuperRole();
        if (roles[2].equals(RoleSuper.NOT_SELECTED.name())) {
            roles[0] = choiceFirstRole();
            roles[1] = choiceSecondRole();
        } else {
            roles[0] = RoleFirstLevel.NOT_SELECTED.name();
            roles[1] = RoleSecondLevel.NOT_SELECTED.name();
        }
        return Arrays.stream(roles).toList();
    }

    public static List<String> getTelephoneNumbers() {
        List<String> telephoneNumbers = new ArrayList<>();
        telephoneNumbers.add(getTelephoneNumber());
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

    public static String getTelephoneNumber() {
        while (true) {
            System.out.println("Enter telephone number:");
            Scanner in = new Scanner(System.in);
            String telNumber = in.next();
            if (!TelephoneNumberValidator.isValid(telNumber)) {

                System.out.println("Error, please input valid phone number");
            } else {
                return telNumber;
            }
        }
    }

}
