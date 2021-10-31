package domain;

import java.util.LinkedList;
import java.util.List;

public class ReferenseBook {
    final List<User> userList;
    public ReferenseBook(LinkedList<User> userList)
    {
        this.userList = userList;
    }
    public void addUser(User user)
    {
        userList.add(user);
    }

    @Override
    public String toString() {
        StringBuilder usersInfo = new StringBuilder();
        int i=1;
        for (User user: userList) {
            usersInfo.append(i).append(". ").append(user.toString()).append("\n");
            i++;
        }
        return usersInfo.toString();
    }
    public int getLenght()
    {
        return userList.size();
    }
    public String deleteById(int id){
        String data=userList.get(id).toString();
        userList.remove(id);
        return data;
    }

    public User getUserById(int id)
    {
        return userList.get(id);
    }

    public List<User> getUserList() {
        return userList;
    }

    public String UsersNamesToString() {
        StringBuilder usersName = new StringBuilder();
        int i=1;
        for (User user: userList) {
            usersName.append(i).append(". ").append(user.getName()).append("\n");
            i++;
        }
        return usersName.toString();
    }
}

