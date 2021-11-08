package service;

import dao.CrudDao;
import dao.UserFile;
import dao.exeption.DaoException;
import domain.ReferenceBook;
import domain.User;
import service.exeption.ServiceException;

import java.util.List;


public class UserService {
    private final ReferenceBook referenceBook;
    private final CrudDao daoImpl;

    public class Transaction {
        private User newState;
        private int id;
        public void start(int id) throws CloneNotSupportedException {
            this.id = id;
            newState = (User) referenceBook.getUserById(id).clone();
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
            referenceBook.getUserList().set(id,newState);
            daoImpl.addUsersListToStorage(referenceBook.getUserList());
        }

    }

    public UserService(CrudDao daoImpl) throws DaoException {
        this.daoImpl = daoImpl;
        this.referenceBook = new ReferenceBook(daoImpl.getUsersFromStorage());
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
        referenceBook.addUser(newUser);
        System.out.println("Created new user\n" + newUser.toString());
        daoImpl.addUserToStorage(newUser);
        System.out.println("User added successfully!");
    }

    public String deleteUserById(int id) throws ServiceException {
        try {
            String deleteUserInfo;
            deleteUserInfo = referenceBook.deleteById(id);
            daoImpl.addUsersListToStorage(referenceBook.getUserList());
            return deleteUserInfo;
        }
        catch (Exception exception)
        {
            throw new ServiceException("Error delete user by id");
        }
    }

    public String getUserInfoById(int id) throws ServiceException {
        try{
            return referenceBook.getUserById(id).toString();
        }
        catch (Exception exception)
        {
            throw new ServiceException("Error get user by id");
        }
    }

    public int getLengthOfReferenceBook() {
        return referenceBook.getLength();
    }

    public String getUsersNames() {
        return referenceBook.UsersNamesToString();
    }

    public String getReferenceBookInfo() {
        return referenceBook.toString();
    }

    public int getCountTelephoneNumbersOfUser(int id) {
        return referenceBook.getUserById(id).getTelephoneNumbers().size();
    }

    public Transaction newTransaction() {
        return new Transaction();
    }
}
