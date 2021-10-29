package service;

import dao.FileWork;
import dao.exeption.UserReadError;
import domain.ReferenseBook;
import domain.User;
import ui.menu.CreateMenu;
import ui.menu.StartMenu;

import java.util.Scanner;

public class Manager {
    private ReferenseBook referenseBook;
    private FileWork fileWork;
    private final UserService userServise;

    public Manager() throws UserReadError {
        FileWork fileWork= new FileWork();
        this.referenseBook = new ReferenseBook(fileWork.getUsersFromStorage());
        userServise = new UserService();
    }

    public void start() {
        try {
            while (true) {
                StartMenu.show();
                switch (StartMenu.getChoice()) {
                    case (1): {
                        User newUser = UserService.createUser(
                                CreateMenu.getName(),
                                CreateMenu.getSurName(),
                                CreateMenu.getEmail(),
                                CreateMenu.getTelephoneNumbers(),
                                CreateMenu.getRoles()
                        );
                        referenseBook.addUser(newUser);
                        System.out.println("Created new user\n" + newUser.toString());
                        fileWork.addUserToStorage(newUser);
                        System.out.println("User added successfully!");
                        System.out.println("Press Enter to continue");
                        Scanner a = new Scanner(System.in);
                        a.nextLine();
                        break;
                    }
                    case (2): {

                    }
                    case (3): {

                    }
                    case (4): {

                    }
                    case (5): {
                        System.out.println("\t\t\t\tAll Users:");
                        System.out.println(referenseBook);
                        System.out.println("Press Enter to continue");
                        Scanner a = new Scanner(System.in);
                        a.nextLine();
                        break;
                    }
                    case (0): {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
