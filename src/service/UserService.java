package service;

import dao.FileWork;
import dao.exeption.DaoException;
import domain.ReferenseBook;
import domain.User;

import java.util.List;


public class UserService {
    private final ReferenseBook referenseBook;
    private final FileWork fileWork;
    public UserService() throws DaoException {
        this.fileWork = new FileWork();
        this.referenseBook = new ReferenseBook(fileWork.getUsersFromStorage());
    }

    public ReferenseBook getReferenseBook() {
        return referenseBook;
    }

    public  User createUser(String name, String surName, String email, List<String> telephones, List<String> roles)
    {
        return User.newBuilder()
                .name(name)
                .surName(surName)
                .email(email)
                .telephoneNumbers(telephones)
                .RoleFirstlevel(roles.get(0))
                .roleSecondLevel(roles.get(1))
                .RoleSuper(roles.get(2))
                .build();
    }
    public void addUser(User newUser) throws DaoException {
        referenseBook.addUser(newUser);
        System.out.println("Created new user\n" + newUser.toString());
        fileWork.addUserToStorage(newUser);
        System.out.println("User added successfully!");
    }
     public String deleteUserById(int id) throws DaoException {
        String deleteUserInfo;
        deleteUserInfo=referenseBook.deleteById(id);
        fileWork.addUsersListToStorage(referenseBook.getUserList());
        return deleteUserInfo;
     }


}
