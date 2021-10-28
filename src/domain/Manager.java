package domain;

import ui.menu.CreateMenu;
import ui.menu.StartMenu;

public class Manager {
    ReferenseBook referenseBook;

    public Manager() {
        referenseBook = new ReferenseBook();
    }

    public void start() {
        StartMenu.show();
        while (true) {
            switch (StartMenu.getChoice()) {
                case (1): {
                    User newUser =UserServise.createUser();
                    referenseBook.addUser(newUser);
                    System.out.println(newUser);
                    System.out.println("User added successfully!");
                    break;
                }
                case (2): {

                }
                case (3): {

                }
                case (4): {

                }
                case (5): {

                }
                case (0): {
                    System.exit(0);
                }
            }
        }
    }
}
