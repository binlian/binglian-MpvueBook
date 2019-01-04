package com.binglian.pojo;

import java.util.Date;
import javax.persistence.*;

public class Book {
    @Id
    private Integer id;

    /**
     * 书籍标题
     */
    @Column(name = "book_title")
    private String bookTitle;

    /**
     * 封面地址
     */
    @Column(name = "book_img")
    private String bookImg;

    /**
     * 书籍描述
     */
    @Column(name = "book_desc")
    private String bookDesc;

    /**
     * 作者
     */
    @Column(name = "book_author")
    private String bookAuthor;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取书籍标题
     *
     * @return book_title - 书籍标题
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * 设置书籍标题
     *
     * @param bookTitle 书籍标题
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * 获取封面地址
     *
     * @return book_img - 封面地址
     */
    public String getBookImg() {
        return bookImg;
    }

    /**
     * 设置封面地址
     *
     * @param bookImg 封面地址
     */
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * 获取书籍描述
     *
     * @return book_desc - 书籍描述
     */
    public String getBookDesc() {
        return bookDesc;
    }

    /**
     * 设置书籍描述
     *
     * @param bookDesc 书籍描述
     */
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    /**
     * 获取作者
     *
     * @return book_author - 作者
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * 设置作者
     *
     * @param bookAuthor 作者
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}