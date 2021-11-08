package service;

import dao.UserFile;
import dao.exeption.DaoException;
import service.exeption.ServiceException;
import ui.menu.UserCreateMenu;
import ui.menu.StartMenu;
import service.validation.NumValidator;

import java.util.Scanner;

public class UiService {
    private final UserService userService;
    private final Scanner in = new Scanner(System.in);

    public UiService() throws DaoException {
        this.userService = new UserService(new UserFile());
    }

    public void start() {
        try {
            while (true) {
                StartMenu.show();
                switch (StartMenu.getChoice()) {
                    case (1) -> createUser();
                    case (2) -> editUser();
                    case (3) -> deleteUser();
                    case (4) -> showUser();
                    case (5) -> showAllUsers();
                    case (0) -> System.exit(0);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void createUser() throws DaoException {
        userService.addUser(userService.createUser(
                UserCreateMenu.getName(),
                UserCreateMenu.getSurName(),
                UserCreateMenu.getEmail(),
                UserCreateMenu.getTelephoneNumbers(),
                UserCreateMenu.getRoles()
        ));
        System.out.println("Press Enter to continue");
        in.nextLine();
    }

    private void editUser() throws CloneNotSupportedException, DaoException, ServiceException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getReferenceBookInfo());
        System.out.println("Enter User Number to edit or 0 to cancel:");
        int number = getUserNumber();
        if (number == 0) {
            return;
        }
        int id = number - 1;
        System.out.println("Chosen User:");
        System.out.println(userService.getUserInfoById(id));
        UserService.Transaction editUserTransaction = userService.newTransaction();
        editUserTransaction.start(id);
        System.out.println("Edit name? (1/0):");
        if (isAgree()) {
            editUserTransaction.editName(UserCreateMenu.getName());
        }
        System.out.println("Edit surname? (1/0):");
        if (isAgree()) {
            editUserTransaction.editSurname(UserCreateMenu.getSurName());
        }
        System.out.println("Edit email? (1/0):");
        if (isAgree()) {
            editUserTransaction.editEmail(UserCreateMenu.getEmail());
        }
        System.out.println("Edit telephone Numbers? (1/0):");
        if (isAgree()) {
            int countOfTelNumbers = userService.getCountTelephoneNumbersOfUser(id);
            for (int i = 0; i < countOfTelNumbers; i++) {
                System.out.println("Edit " + (i + 1) + " telephoneNumber? (1/0)");
                if (isAgree()) {
                    editUserTransaction.editTelephoneNumber(i, UserCreateMenu.getTelephoneNumber());
                }
            }
            while (countOfTelNumbers < 3) {
                System.out.println("Add new telephone Number? (1/0)");
                if (isAgree()) {
                    editUserTransaction.addTelephoneNumber(UserCreateMenu.getTelephoneNumber());
                    countOfTelNumbers++;
                } else {
                    break;
                }
            }
        }
        System.out.println("Edit roles ? (1/0)");
        if (isAgree()) {
            editUserTransaction.editRoles(UserCreateMenu.getRoles());
        }
        System.out.println("Previous state:");
        System.out.println(userService.getUserInfoById(id));
        System.out.println("New state:");
        System.out.println(editUserTransaction.getNewStateInfo());
        System.out.println("Save changes ? (1/0)");
        if (isAgree()) {
            editUserTransaction.commit();
            System.out.println("User successful edited");
        } else {
            System.out.println("Editing has been canceled");
        }
        System.out.println("Press Enter to continue");
        in.nextLine();
    }

    private void deleteUser() throws ServiceException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getReferenceBookInfo());
        System.out.println("Enter User Number to delete or 0 to cancel:");
        int number = getUserNumber();
        if (number == 0) {
            return;
        }
        int id = number - 1;
        System.out.println(userService.deleteUserById(id));
        System.out.println("User successful deleted");
        System.out.println("Press Enter to continue");
        in.nextLine();
    }

    private void showUser() throws ServiceException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getUsersNames());
        System.out.println("Enter User number to show info or 0 to cancel:");
        int number = getUserNumber();
        if (number == 0) {
            return;
        }
        int id = number - 1;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tInfo about selected User:");
        System.out.println(userService.getUserInfoById(id));
        System.out.println("Press Enter to continue");
        in.nextLine();
    }

    private void showAllUsers() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAll Users:");
        System.out.println(userService.getReferenceBookInfo());
        System.out.println("Press Enter to continue");
        in.nextLine();
    }

    private int getUserNumber() {
        String id;
        NumValidator numValidator;
        while (true) {
            id = in.next();
            in.nextLine();
            numValidator = new NumValidator(id, 0, userService.getLengthOfReferenceBook());
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                break;
            }
        }
        return numValidator.getNum();
    }

    private boolean isAgree() {
        String id;
        NumValidator numValidator;
        while (true) {
            id = in.next();
            in.nextLine();
            numValidator = new NumValidator(id, 0, 1);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                break;
            }
        }
        return numValidator.getNum() == 1;
    }

}
