package domain;

import java.util.LinkedList;
import java.util.List;

public class ReferenseBook {
    List<User> userList;
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
        StringBuffer usersInfo = new StringBuffer();
        for (User user: userList) {
            usersInfo.append(user.toString()+"\n");
        }
        return usersInfo.toString();
    }
}

