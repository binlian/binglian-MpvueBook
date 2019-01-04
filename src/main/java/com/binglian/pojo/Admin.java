package com.binglian.pojo;

import java.util.Date;
import javax.persistence.*;

public class Admin {
    @Id
    private Integer id;

    /**
     * 账户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 角色授权
     */
    private String roles;

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
     * 获取账户
     *
     * @return username - 账户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账户
     *
     * @param username 账户
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取角色授权
     *
     * @return roles - 角色授权
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色授权
     *
     * @param roles 角色授权
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
}