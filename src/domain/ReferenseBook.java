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
        for (User user: userList) {
            usersInfo.append(user.toString()).append("\n");
        }
        return usersInfo.toString();
    }
}

