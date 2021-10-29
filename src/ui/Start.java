package ui;

import dao.exeption.UserReadError;
import service.Manager;


public class Start {

    public static void main(String[] args) throws UserReadError {
       Manager manager=new Manager();
       manager.start();
    }
}
