package service;

import domain.User;
import ui.menu.CreateMenu;

import java.util.List;


public class UserService {
    public static User createUser(String name, String surName, String email, List<String> telephones, List<String> roles)
    {
        User newUser = User.newBuilder()
                .name(name)
                .surName(surName)
                .email(email)
                .telephoneNumbers(telephones)
                .RoleFirstlevel(roles.get(0))
                .roleSecondLevel(roles.get(1))
                .RoleSuper(roles.get(2))
                .build();
        return newUser;
    }

}