package ui;

import dao.FileWork;
import dao.exeption.UserReadError;
import service.Manager;

import java.io.FileReader;


public class Start {

    public static void main(String[] args) throws UserReadError {
       Manager manager=new Manager();
       manager.start();
    }
}
