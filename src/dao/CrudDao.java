package dao;

import dao.exeption.UserReadError;
import dao.exeption.UserSaveError;
import domain.User;

import java.util.LinkedList;

public interface CrudDao {
    void addUserToStorage(User user) throws UserSaveError;
    LinkedList<User> getUsersFromStorage() throws UserReadError;
}

