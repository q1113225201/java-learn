package com.sjl.learn.domain;

import java.io.Serializable;

public class UserBean implements Serializable {
    private Long id;
    private String nickname;
    private int age;
    private boolean sex;

    public UserBean() {
    }

    public UserBean(String nickname, int age, boolean sex) {
        this.nickname = nickname;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UserBean)) {
            return false;
        }
        UserBean userBean = (UserBean) obj;
        return userBean.getId() == id;
    }
}
