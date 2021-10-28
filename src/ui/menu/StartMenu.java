package ui.menu;

import ui.validation.NumValidator;

import java.util.Scanner;

public class StartMenu {
    public static void show() {
        System.out.println("\t\t\t\tМеню:");
        System.out.println("1.Добавить пользователя");
        System.out.println("2.Редактировать пользователя");
        System.out.println("3.Удалить пользователя");
        System.out.println("4.Вывести информацию о пользователе");
        System.out.println("5.Вывести информацию о всех пользователях");
        System.out.println("0.Выход");
    }

    public static int getChoice() {
        Scanner in = new Scanner(System.in);
        String choice;
        while (true) {
            choice = in.next();
            NumValidator numValidator = new NumValidator(choice, 0, 5);
            if (!numValidator.checkValidNum()) {
                System.out.println("Error, please input valid number");
            } else {
                return numValidator.getNum();
            }
        }
    }

}
