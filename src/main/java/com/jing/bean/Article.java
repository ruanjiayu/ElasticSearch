package com.jing.bean;

import io.searchbox.annotations.JestId;

/**
 * @author ruanjiayu
 * @dateTime 2019/4/3 11:02
 */
public class Article {

    @JestId
    private String id;

    private String title;

    private String author;

    private String content;


    public Article() {
    }

    public Article(String id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
