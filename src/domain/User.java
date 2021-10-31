package domain;

import domain.roles.RoleFirstLevel;
import domain.roles.RoleSecondLevel;
import domain.roles.RoleSuper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Cloneable{

    private String name;
    private String surName;
    private String email;
    private RoleFirstLevel roleFirstLevel = RoleFirstLevel.NOT_SELECTED;
    private RoleSecondLevel roleSecondLevel= RoleSecondLevel.NOT_SELECTED;
    private RoleSuper roleSuper =RoleSuper.NOT_SELECTED;
    private List<String> telephoneNumbers;

    public User() {
        telephoneNumbers = new ArrayList<>();
    }

    public User(String name, String surName, String email, RoleFirstLevel roleFirstLevel, RoleSecondLevel roleSecondLevel, RoleSuper roleSuper, ArrayList<String> telephoneNumbers) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.roleFirstLevel = roleFirstLevel;
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

    public List<String> getTelephoneNumbers() {
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

    public void setRoleFirstLevel(String roleFirstLevel) {
        if (RoleFirstLevel.USER.name().equals(roleFirstLevel)) {
            User.this.roleFirstLevel = RoleFirstLevel.USER;
        } else if (RoleFirstLevel.CUSTOMER.name().equals(roleFirstLevel)) {
            User.this.roleFirstLevel = RoleFirstLevel.CUSTOMER;
        } else {
            User.this.roleFirstLevel = RoleFirstLevel.NOT_SELECTED;
        }
    }

    public void setRoleSecondLevel(String roleSecondLevel) {
        if (RoleSecondLevel.ADMIN.name().equals(roleSecondLevel)) {
            User.this.roleSecondLevel = RoleSecondLevel.ADMIN;
        } else if (RoleSecondLevel.PROVIDER.name().equals(roleSecondLevel)) {
            User.this.roleSecondLevel = RoleSecondLevel.PROVIDER;
        } else {
            User.this.roleSecondLevel = RoleSecondLevel.NOT_SELECTED;
        }
    }

    public void setRoleSuper(String roleSuper) {
        if (RoleSuper.SUPER_ADMIN.name().equals(roleSuper)) {
            User.this.roleSuper = RoleSuper.SUPER_ADMIN;
        } else {
            User.this.roleSuper = RoleSuper.NOT_SELECTED;
        }
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    @Override
    public String toString() {
        return "name= '" + name + '\'' +
                ", surName= '" + surName + '\'' +
                ", email= '" + email + '\'' +
                ", roleFirstLevel= '" + roleFirstLevel + '\'' +
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        User newUser = (User) super.clone();
        newUser.telephoneNumbers = new ArrayList<>(telephoneNumbers);
        return newUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surName, user.surName)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (roleFirstLevel != user.roleFirstLevel) return false;
        if (roleSecondLevel != user.roleSecondLevel) return false;
        if (roleSuper != user.roleSuper) return false;
        return Objects.equals(telephoneNumbers, user.telephoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, email, roleFirstLevel, roleSecondLevel, roleSuper, telephoneNumbers);
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

        public User.Builder RoleFirstLevel(String roleFirstLevel) {
            setRoleFirstLevel(roleFirstLevel);
            return this;
        }

        public User.Builder roleSecondLevel(String role) {
            setRoleSecondLevel(role);
            return this;
        }

        public User.Builder RoleSuper(String role) {
            setRoleSuper(role);
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
