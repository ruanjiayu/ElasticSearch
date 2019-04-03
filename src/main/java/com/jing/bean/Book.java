package com.jing.bean;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author ruanjiayu
 * @dateTime 2019/4/3 13:40
 */
/**下面的indexName表示索引的名字，type表示归属于那一类*/
@Document(indexName = "sx",type = "book")
public class Book {

    private String id;

    private String name;

    private String author;

    /**
     * 注意需要这个无参数构造，不然会失败，不能从elasticsearch中获取
     */
    public Book() {
    }

    public Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
