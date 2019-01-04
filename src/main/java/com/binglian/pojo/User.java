package com.binglian.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    private Integer id;

    /**
     * 用户账户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户账户
     *
     * @return username - 用户账户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户账户
     *
     * @param username 用户账户
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}