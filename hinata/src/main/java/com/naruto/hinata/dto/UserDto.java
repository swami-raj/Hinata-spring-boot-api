package com.naruto.hinata.dto;

public class UserDto {
    private long id;
    private String name;
    private String mail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserDto(long id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }
}
