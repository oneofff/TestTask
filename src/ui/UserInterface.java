package ui;

import ui.menu.CreateMenu;
import ui.menu.StartMenu;

public class UserInterface {

    public static void start() {
        StartMenu.show();
        while (true) {
            switch (StartMenu.getChoice()) {
                case (1): {
                    CreateMenu.getName();
                    CreateMenu.getSurName();
                    CreateMenu.getEmail();
                    if (CreateMenu.choiceSuperRole()==1)
                    {

                    }
                    else {
                        CreateMenu.choiceFirstRole();
                        CreateMenu.choiceSecondRole();
                    }
                    CreateMenu.getTelephoneNumbers();

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
