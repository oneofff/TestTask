package ui;

import dao.exeption.DaoException;
import service.Manager;


public class Start {

    public static void main(String[] args) throws DaoException {
       Manager manager=new Manager();
       manager.start();
    }
}
