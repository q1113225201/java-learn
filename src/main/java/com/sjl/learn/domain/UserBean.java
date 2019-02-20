package com.sjl.learn.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@EntityScan
public class UserBean implements Serializable {
    private Long id;
    @NotEmpty(message = "昵称不能为空")
    @Size(min = 2, max = 8, message = "姓名不能少于2大于8")
    private String nickname;
    @Min(value = 0, message = "年龄不能小于0")
    private int age;
    private boolean sex;

    public UserBean(String nickname, int age, boolean sex) {
        this.nickname = nickname;
        this.age = age;
        this.sex = sex;
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
}
