package domain;

import ui.menu.CreateMenu;

public class UserServise {
    public static User createUser()
    {

        User newUser = User.newBuilder()
                    .name(CreateMenu.getName())
                    .surName(CreateMenu.getSurName())
                    .email( CreateMenu.getEmail())
                    .telephoneNumbers(CreateMenu.getTelephoneNumbers())
                    .build();
        if (CreateMenu.choiceSuperRole()==1)
        {
            newUser.setRoleThirdLevel();
        }
        else {
            newUser.setRoleFirstlevel(CreateMenu.choiceFirstRole());
            newUser.setRoleSecondLevel(CreateMenu.choiceSecondRole());
        }
        return newUser;
    }
}
