package com.snomyc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.snomyc.base.domain.BaseEntity;

@Entity
public class User extends BaseEntity{
    
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique = true)
    private String userName;
	
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private int age;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
