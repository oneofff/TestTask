package dao;

import dao.exeption.UserReadError;
import dao.exeption.UserSaveError;
import domain.User;

import java.util.ArrayList;
import java.util.LinkedList;

public interface CrudDao {
    public void addUserToStorage(User user) throws UserSaveError;
    public LinkedList<User> getUsersFromStorage() throws UserReadError;
}

