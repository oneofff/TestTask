package domain;

import domain.roles.RoleFirstlevel;
import domain.roles.RoleSecondLevel;
import domain.roles.RoleThirdLevel;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private String surName;
    private String email;
    private RoleFirstlevel roleFirstlevel;
    private RoleSecondLevel roleSecondLevel;
    private RoleThirdLevel roleThirdLevel;
    private ArrayList<TelephoneNumber> telephoneNumbers;

    public User() {
        telephoneNumbers = new ArrayList<TelephoneNumber>();
    }

    public User(String name, String surName, String email, RoleFirstlevel roleFirstlevel, RoleSecondLevel roleSecondLevel, RoleThirdLevel roleThirdLevel, ArrayList<TelephoneNumber> telephoneNumbers) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.roleFirstlevel = roleFirstlevel;
        this.roleSecondLevel = roleSecondLevel;
        this.roleThirdLevel = roleThirdLevel;
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public RoleFirstlevel getRoleFirstlevel() {
        return roleFirstlevel;
    }

    public RoleSecondLevel getRoleSecondLevel() {
        return roleSecondLevel;
    }

    public RoleThirdLevel getRoleThirdLevel() {
        return roleThirdLevel;
    }

    public ArrayList<TelephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleFirstlevel(RoleFirstlevel roleFirstlevel) {
        this.roleFirstlevel = roleFirstlevel;
    }

    public void setRoleSecondLevel(RoleSecondLevel roleSecondLevel) {
        this.roleSecondLevel = roleSecondLevel;
    }

    public void setRoleThirdLevel(RoleThirdLevel roleThirdLevel) {
        this.roleThirdLevel = roleThirdLevel;
    }
    public void setRoleFirstlevel(int choice) {
        if (choice==1) {
            this.roleFirstlevel = RoleFirstlevel.User;
        }
        else
        {
            this.roleFirstlevel = RoleFirstlevel.Customer;
        }
    }

    @Override
    public String toString() {
        return  "name= '" + name + '\'' +
                ", surName= '" + surName + '\'' +
                ", email= '" + email + '\'' +
                ", roleFirstlevel= " + roleFirstlevel +
                ", roleSecondLevel= " + roleSecondLevel +
                ", roleThirdLevel= " + roleThirdLevel +
                ", telephoneNumbers= " + telephoneNumbers;
    }

    public void setRoleSecondLevel(int choice) {
        if (choice==1) {
            this.roleSecondLevel = RoleSecondLevel.ADMIN;
        }
        else
        {
            this.roleSecondLevel = RoleSecondLevel.PROVIDER;
        }
    }

    public void setRoleThirdLevel() {
        this.roleThirdLevel = RoleThirdLevel.SUPER_ADMIN;
    }

    public void setTelephoneNumbers(ArrayList<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public static User.Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public User.Builder name(String name) {
            User.this.name = name;
            return this;
        }

        public User.Builder surName(String surName) {
            User.this.surName = surName;
            return this;
        }

        public User.Builder email(String email) {
            User.this.email = email;
            return this;
        }

        public User.Builder setRoleFirstlevel(RoleFirstlevel roleFirstlevel) {
            User.this.roleFirstlevel = roleFirstlevel;
            return this;
        }

        public User.Builder roleSecondLevel(RoleSecondLevel roleSecondLevel) {
            User.this.roleSecondLevel = roleSecondLevel;
            return this;
        }

        public User.Builder roleThirdLevel(RoleThirdLevel roleThirdLevel) {
            User.this.roleThirdLevel = roleThirdLevel;
            return this;
        }

        public User.Builder telephoneNumbers(ArrayList<TelephoneNumber> telephoneNumbers) {
            User.this.telephoneNumbers = telephoneNumbers;
            return this;
        }
        public User build() {
            return User.this;
        }

    }
}
