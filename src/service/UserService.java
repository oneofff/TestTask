package service;

import dao.UserFile;
import dao.exeption.DaoException;
import domain.ReferenseBook;
import domain.User;

import java.util.List;


public class UserService {
    private final ReferenseBook referenseBook;
    private final UserFile userFile;
    public UserService() throws DaoException {
        this.userFile = new UserFile();
        this.referenseBook = new ReferenseBook(userFile.getUsersFromStorage());
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
        userFile.addUserToStorage(newUser);
        System.out.println("User added successfully!");
    }
     public String deleteUserById(int id) throws DaoException {
        String deleteUserInfo;
        deleteUserInfo=referenseBook.deleteById(id);
        userFile.addUsersListToStorage(referenseBook.getUserList());
        return deleteUserInfo;
     }


}
