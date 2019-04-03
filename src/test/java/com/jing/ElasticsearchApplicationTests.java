package com.jing;

import com.jing.bean.Article;
import com.jing.bean.Book;
import com.jing.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

	@Autowired
	JestClient jestClient;

	@Test
	public void contextLoads() {
	}

	/**
	 * 向elasticsearch内放置内容
	 */
	@Test
	public void put(){
		Article article = new Article();
		article.setId("1");
		article.setTitle("感悟");
		article.setAuthor("ruanjiayu");
		article.setContent("从你拿起武器的那一刻，战斗就会展现在面前");
		//构建一个索引功能,仔细看下面的表达式，有坑的
		Index index = new Index.Builder(article).index("hs").type("shout").build();

		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void search(){

		//查询表达式
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"武器\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		Search build = new Search.Builder(json).addIndex("hs").addType("shout").build();

		try {
			SearchResult result = jestClient.execute(build);
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 下面使用了springdata-elasticSearch的方式
	 */

	@Autowired
	BookRepository bookRepository;


	@Test
	public void test(){
		//创建一个索引序列
		Book book = new Book("3","龙族","ruanjiayu");
		bookRepository.index(book);
	}

	@Test
	public void searchTest(){
		//模糊查询文档
		for (Book book : bookRepository.findByNameLike("龙")) {
			System.out.println(book);
		}

	}

}
