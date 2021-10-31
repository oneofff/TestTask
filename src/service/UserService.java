package service;

import dao.UserFile;
import dao.exeption.DaoException;
import domain.ReferenseBook;
import domain.User;

import java.util.List;


public class UserService {
    private final ReferenseBook referenseBook;
    private final UserFile userFile;

    public class Transaction {
        private User newState;
        private int id;
        public void start(int id) throws CloneNotSupportedException {
            this.id = id;
            newState = (User) referenseBook.getUserById(id).clone();
        }

        public void editName(String name) {
            newState.setName(name);
        }

        public void editSurname(String surname) {
            newState.setSurName(surname);
        }

        public void editEmail(String email) {
            newState.setEmail(email);
        }

        public void editTelephoneNumber(int indexOfTel, String telephoneNumber) {
            newState.getTelephoneNumbers().set(indexOfTel, telephoneNumber);
        }

        public void editRoles(List<String> roles) {
            newState.setRoleFirstLevel(roles.get(0));
            newState.setRoleSecondLevel(roles.get(1));
            newState.setRoleSuper(roles.get(2));
        }

        public void addTelephoneNumber(String telephoneNumber) {
            newState.getTelephoneNumbers().add(telephoneNumber);
        }

        public String getNewStateInfo() {
            return newState.toString();
        }

        public void commit() throws DaoException {
            referenseBook.getUserList().set(id,newState);
            userFile.addUsersListToStorage(referenseBook.getUserList());
        }

    }

    public UserService() throws DaoException {
        this.userFile = new UserFile();
        this.referenseBook = new ReferenseBook(userFile.getUsersFromStorage());
    }

    public User createUser(String name, String surName, String email, List<String> telephones, List<String> roles) {
        return User.newBuilder()
                .name(name)
                .surName(surName)
                .email(email)
                .telephoneNumbers(telephones)
                .RoleFirstLevel(roles.get(0))
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
        deleteUserInfo = referenseBook.deleteById(id);
        userFile.addUsersListToStorage(referenseBook.getUserList());
        return deleteUserInfo;
    }

    public String getUserInfoById(int id) {
        return referenseBook.getUserById(id).toString();
    }

    public int getLengthOfReferenseBook() {
        return referenseBook.getLenght();
    }

    public String getUsersNames() {
        return referenseBook.UsersNamesToString();
    }

    public String getReferenceBookInfo() {
        return referenseBook.toString();
    }

    public int getCountTelephoneNumbersOfUser(int id) {
        return referenseBook.getUserById(id).getTelephoneNumbers().size();
    }

    public Transaction newTransaction() {
        Transaction transaction = new Transaction();
        return transaction;
    }
}
