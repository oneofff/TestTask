package service;

import dao.exeption.DaoException;
import domain.User;
import ui.menu.CreateMenu;
import ui.menu.StartMenu;
import ui.validation.NumValidator;

import java.util.Scanner;

public class Manager {
    UserService userService;
    Scanner in = new Scanner(System.in);

    public Manager() throws DaoException {
        this.userService = new UserService();
    }

    public void start() {
        try {
            while (true) {
                StartMenu.show();
                switch (StartMenu.getChoice()) {
                    case (1): {
                        createUser();
                        break;
                    }
                    case (2): {

                        break;
                    }
                    case (3): {
                        deleteUser();
                        break;
                    }
                    case (4): {
                        showUser();
                        break;
                    }
                    case (5): {
                        showAllUsers();
                        break;
                    }
                    case (0): {
                        System.exit(0);
                        break;
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void createUser() throws DaoException {
        User newUser = userService.createUser(
                CreateMenu.getName(),
                CreateMenu.getSurName(),
                CreateMenu.getEmail(),
                CreateMenu.getTelephoneNumbers(),
                CreateMenu.getRoles()
        );
        userService.addUser(newUser);
        System.out.println("\nPress Enter to continue");
        in.nextLine();
    }
 
    private void deleteUser() throws DaoException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getReferenseBookInfo());
        System.out.println("Enter User Number to delete or 0 to cancel:");
        String id;
        NumValidator numValidator;
        while (true) {
            id = in.next();
            numValidator = new NumValidator(id, 0, userService.getLengthOfReferenseBook());
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                break;
            }
        }
        in.nextLine();
        if (numValidator.getNum() == 0) {
            return;
        }
        System.out.println(userService.deleteUserById(numValidator.getNum() - 1));
        System.out.println("User successful deleted");
        System.out.println("\nPress Enter to continue");
        in.nextLine();
    }

    private void showUser()
    {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getUsersNames());
        System.out.println("Enter User number to show info or 0 to cancel:");
        String id;
        NumValidator numValidator;
        while (true) {
            id = in.next();
            numValidator = new NumValidator(id, 0, userService.getLengthOfReferenseBook());
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                break;
            }
        }
        in.nextLine();
        if (numValidator.getNum() == 0) {
            return;
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInfo about selected User:");
        System.out.println(userService.getUserInfoById(numValidator.getNum() - 1));
        System.out.println("\nPress Enter to continue");
        in.nextLine();
    }

    private void showAllUsers() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getReferenseBookInfo());
        System.out.println("\nPress Enter to continue");
        in.nextLine();
    }
}
