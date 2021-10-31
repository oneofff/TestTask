package domain;

import domain.roles.RoleFirstlevel;
import domain.roles.RoleSecondLevel;
import domain.roles.RoleSuper;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String surName;
    private String email;
    private RoleFirstlevel roleFirstlevel;
    private RoleSecondLevel roleSecondLevel;
    private RoleSuper roleSuper;
    private List<String> telephoneNumbers;

    public User() {
        telephoneNumbers = new ArrayList<>();
    }

    public User(String name, String surName, String email, RoleFirstlevel roleFirstlevel, RoleSecondLevel roleSecondLevel, RoleSuper roleSuper, ArrayList<String> telephoneNumbers) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.roleFirstlevel = roleFirstlevel;
        this.roleSecondLevel = roleSecondLevel;
        this.roleSuper = roleSuper;
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getName() { return name; }

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

    public RoleSuper getRoleThirdLevel() {
        return roleSuper;
    }

    public List<String> getStrings() {
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

    public void setRoleSuper(RoleSuper roleSuper) {
        this.roleSuper = roleSuper;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    @Override
    public String toString() {
        return "name= '" + name + '\'' +
                ", surName= '" + surName + '\'' +
                ", email= '" + email + '\'' +
                ", roleFirstlevel= '" + roleFirstlevel + '\'' +
                ", roleSecondLevel= '" + roleSecondLevel + '\'' +
                ", roleSuper= '" + roleSuper + '\'' +
                ", telephoneNumbers= '" + telephoneNumbersToString() + '\'';
    }

    private String telephoneNumbersToString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < telephoneNumbers.size(); i++) {
            buffer.append(telephoneNumbers.get(i));
            if (i == telephoneNumbers.size() - 1)
                continue;
            buffer.append(",");
        }
        return buffer.toString();
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

        public User.Builder RoleFirstlevel(String roleFirstlevel) {
            if (RoleFirstlevel.USER.name().equals(roleFirstlevel)) {
                User.this.roleFirstlevel = RoleFirstlevel.USER;
            } else if (RoleFirstlevel.CUSTOMER.name().equals(roleFirstlevel)) {
                User.this.roleFirstlevel = RoleFirstlevel.CUSTOMER;
            } else {
                User.this.roleFirstlevel = RoleFirstlevel.NOT_SELECTED;
            }
            return this;
        }

        public User.Builder roleSecondLevel(String role) {
            if (RoleSecondLevel.ADMIN.name().equals(role)) {
                User.this.roleSecondLevel = RoleSecondLevel.ADMIN;
            } else if (RoleSecondLevel.PROVIDER.name().equals(role)) {
                User.this.roleSecondLevel = RoleSecondLevel.PROVIDER;
            } else {
                User.this.roleSecondLevel = RoleSecondLevel.NOT_SELECTED;
            }
            return this;
        }

        public User.Builder RoleSuper(String role) {
            if (RoleSuper.SUPER_ADMIN.name().equals(role)) {
                User.this.roleSuper = RoleSuper.SUPER_ADMIN;
            } else {
                User.this.roleSuper = RoleSuper.NOT_SELECTED;
            }

            return this;
        }

        public User.Builder telephoneNumbers(List<String> telephoneNumbers) {
            User.this.telephoneNumbers = telephoneNumbers;
            return this;
        }

        public User build() {
            return User.this;
        }

    }

}//TODO override equals hashcode and clone
