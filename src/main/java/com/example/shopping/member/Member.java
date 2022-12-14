package com.example.shopping.member;


public class Member {
    private String id;
    private String name;
    private Grade grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Member(String id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
