package dao;

import dao.exeption.DaoException;
import domain.User;

import java.util.LinkedList;
import java.util.List;

public interface CrudDao {
    void addUserToStorage(User user) throws DaoException;
    LinkedList<User> getUsersFromStorage() throws DaoException;
    void addUsersListToStorage(List<User> user) throws DaoException ;
}

