package domain;

import domain.roles.RoleFirstlevel;
import domain.roles.RoleSecondLevel;
import domain.roles.RoleThirdLevel;

import java.util.LinkedList;

public class User {
    private  String name;
    private  String surName;
    private  String email;



    private  RoleFirstlevel roleFirstlevel;
    private  RoleSecondLevel roleSecondLevel;
    private  RoleThirdLevel roleThirdLevel;
    private  LinkedList<TelephoneNumber> telephoneNumbers;

    public User() {
        telephoneNumbers= new LinkedList<TelephoneNumber>();
    }

    public User(String name, String surName, String email, RoleFirstlevel roleFirstlevel, RoleSecondLevel roleSecondLevel, RoleThirdLevel roleThirdLevel, LinkedList<TelephoneNumber> telephoneNumbers) {
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

    public LinkedList<TelephoneNumber> getTelephoneNumbers() {
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

    public void setTelephoneNumbers(LinkedList<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }
}
