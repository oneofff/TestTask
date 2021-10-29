package dao;

import dao.exeption.UserReadError;
import dao.exeption.UserSaveError;
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

public  class FileWork implements CrudDao {
    @Override
    public  LinkedList<User> getUsersFromStorage() throws UserReadError {
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
            User user = UserService.createUser(data[0],data[1],data[2],phoneNumbs,roles);
            usersListFormFile.add(user);
            }
        }
        catch(Exception exception){
            throw new UserReadError();
        }
        return usersListFormFile;
    }

    private List<String> getPhonesFromDataParse(String[] data)
    {
        List<String> telephoneNums= new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(data[6]);
        while (matcher.find()) {
            telephoneNums.add(data[6].substring(matcher.start(), matcher.end()));
        }
        return telephoneNums;
    }
    private List<String> getRolesFromDataParse(String[] data)
    {
        List<String> roles= new ArrayList<>();
        roles.add(data[3]);
        roles.add(data[4]);
        roles.add(data[5]);

        return roles;
    }
    private String[] dataParse(String data)
    {
        Pattern pattern = Pattern.compile("'.+?'");
        Matcher matcher = pattern.matcher(data);
        String[] resulted= new String[7];
        for (int i = 0; i < 7; i++) {
            matcher.find();
            resulted[i]=  data.substring(matcher.start()+1, matcher.end()-1);
        }
        return resulted;
    }
    @Override
    public void addUserToStorage(User user) throws UserSaveError {
        try(FileWriter writer = new FileWriter("usersData.txt", true))
        {
            writer.append(user.toString()).append("\n");
            writer.flush();
        }
        catch(Exception exception){
            throw new UserSaveError();
        }
    }
}
