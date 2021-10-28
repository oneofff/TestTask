package domain;

import java.util.LinkedList;

public class ReferenseBook {
    LinkedList<User> userList;
    public ReferenseBook()
    {
        userList =new LinkedList<>();
    }
    public void addUser(User user)
    {
        userList.add(user);
    }

    @Override
    public String toString() {
        StringBuffer usersInfo = new StringBuffer();
        for (User user: userList) {
            usersInfo.append(user.toString());
        }
        return usersInfo.toString();
    }
}

