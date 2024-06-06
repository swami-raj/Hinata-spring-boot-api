package com.naruto.hinata.dto;

public class SignupDto {
    private Long id;
    private String name;
    private String gmail;
    private String address;

    public SignupDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SignupDto(Long id, String name, String gmail, String address) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.address = address;
    }
}
