package com.example.httpmessageconverter;

/**
 * ClassName: User
 * Description: TODO
 * Author : Administrator
 * Date : 2019/8/7 16:57
 * Version : 1.0
 **/
public class User {
    private String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Integer age) {
        this.age = age;
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
