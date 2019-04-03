package com.jing.repository;

import com.jing.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ruanjiayu
 * @dateTime 2019/4/3 13:38
 */
public interface BookRepository extends ElasticsearchRepository<Book,String> {

    /**
     * 详细的构造方法参考：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.6.RELEASE/reference/html/#elasticsearch.query-methods
     * @param bookName
     * @return
     */
    List<Book> findByNameLike(String bookName);
}
