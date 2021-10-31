package dao;

import dao.exeption.DaoException;
import domain.User;
import service.UserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class UserFile implements CrudDao {
    @Override
    public  LinkedList<User> getUsersFromStorage() throws DaoException {
        LinkedList<User> usersListFormFile = new LinkedList<>();
        try(FileReader read = new FileReader("usersData.txt"))
        {
            BufferedReader reader = new BufferedReader(read);
            String line;
            while (true) {
            line= reader.readLine();
            if (line==null)
            {
                break;
            }
            String[] data = dataParse(line);
            List<String> phoneNumbs = getPhonesFromDataParse(data);
            List<String> roles = getRolesFromDataParse(data);
            User user = User.newBuilder()
                        .name(data[0])
                        .surName(data[1])
                        .email(data[2])
                        .telephoneNumbers(phoneNumbs)
                        .RoleFirstlevel(roles.get(0))
                        .roleSecondLevel(roles.get(1))
                        .RoleSuper(roles.get(2))
                        .build();
            usersListFormFile.add(user);
            }
        }
        catch(Exception exception){
            throw new DaoException("Error read user from file");
        }
        return usersListFormFile;
    }

    private List<String> getPhonesFromDataParse(String[] data) throws DaoException {
        try {


            List<String> telephoneNums = new ArrayList<>();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(data[6]);
            while (matcher.find()) {
                telephoneNums.add(data[6].substring(matcher.start(), matcher.end()));
            }
            return telephoneNums;
        }
        catch (Exception exception)
        {
            throw new DaoException("Error get phones from data");
        }
    }
    private List<String> getRolesFromDataParse(String[] data) throws DaoException {
        try {
            List<String> roles = new ArrayList<>();
            roles.add(data[3]);
            roles.add(data[4]);
            roles.add(data[5]);
            return roles;
        }
        catch (Exception exception){
            throw new DaoException("Error get roles from data ");
        }

    }
    private String[] dataParse(String data) throws DaoException {
        try {

            Pattern pattern = Pattern.compile("'.+?'");
            Matcher matcher = pattern.matcher(data);
            String[] resulted = new String[7];
            for (int i = 0; i < 7; i++) {
                matcher.find();
                resulted[i] = data.substring(matcher.start() + 1, matcher.end() - 1);
            }
            return resulted;
        }
        catch (Exception exception)
        {
            throw new DaoException("Error parse data");
        }

    }
    @Override
    public void addUserToStorage(User user) throws DaoException {
        try(FileWriter writer = new FileWriter("usersData.txt", true))
        {
            writer.append(user.toString()).append("\n");
            writer.flush();
        }
        catch(Exception exception){
            throw new DaoException("Error save user to file");
        }
    }
    public void addUsersListToStorage(List<User> users) throws DaoException {
        try(FileWriter writer = new FileWriter("usersData.txt", false))
        {
            for (User user:
                 users) {
                writer.append(user.toString()).append("\n");
                writer.flush();
            }
        }
        catch(Exception exception){
            throw new DaoException("Error save user list to file");
        }
    }
}
